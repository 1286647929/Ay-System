package com.ay.common.utils;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.ay.common.constant.HttpStatus;
import com.ay.common.core.domain.entity.SysUser;
import com.ay.common.core.domain.model.LoginUser;
import com.ay.common.exception.ServiceException;
import com.ay.common.utils.UserAgentUtils.UserAgentUtils;
import com.ay.common.utils.ip.AddressUtils;
import com.ay.common.utils.ip.IpUtils;
import com.ay.common.utils.sign.RSA;
import com.ay.system.service.ISysUserService;
import com.ay.web.service.SysPermissionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 安全服务工具类
 * 
 * @author ruoyi
 */
@Component
public class SecurityUtils {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private SysPermissionService permissionService;

    /**
     * 用户ID
     **/
    public static Long getUserId()
    {
        try
        {
            return (Long) StpUtil.getTokenInfo().getLoginId();
        }
        catch (Exception e)
        {
            throw new ServiceException("获取用户ID异常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 获取部门ID
     **/
    public Long getDeptId()
    {
        try
        {
            return getLoginUser().getDeptId();
        }
        catch (Exception e)
        {
            throw new ServiceException("获取部门ID异常", HttpStatus.UNAUTHORIZED);
        }
    }
    
    /**
     * 获取用户账户
     **/
    public String getUsername()
    {
        try
        {
            return getLoginUser().getUser().getUserName();
        }
        catch (Exception e)
        {
            throw new ServiceException("获取用户账户异常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 获取用户
     **/
    public LoginUser getLoginUser()
    {
        try
        {
            ServletRequestAttributes servletRequestAttributes =
                    (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = servletRequestAttributes.getRequest();

            LoginUser loginUser = new LoginUser();
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            SysUser user = userService.selectUserById(Long.valueOf(String.valueOf(tokenInfo.getLoginId())));
            loginUser.setToken(tokenInfo.getTokenValue());
            loginUser.setUserId(user.getUserId());
            loginUser.setDeptId(user.getDeptId());
            loginUser.setLoginTime(Long.valueOf(DateUtils.getDate()));
            loginUser.setExpireTime(tokenInfo.getTokenTimeout());
            loginUser.setIpaddr(IpUtils.getIpAddr());
            loginUser.setLoginLocation(AddressUtils.getRealAddressByIP(IpUtils.getIpAddr()));
            loginUser.setBrowser(UserAgentUtils.getBrowser(request));
            loginUser.setOs(UserAgentUtils.getOs(request));
            loginUser.setPermissions(permissionService.getMenuPermission(user));
            loginUser.setUser(user);
            return loginUser;
        }
        catch (Exception e)
        {
            throw new ServiceException("获取用户信息异常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password)
    {
        return RSA.rsaEncryptByPublic(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        String decodePassword = RSA.rsaDecryptByPrivate(encodedPassword);
        return StringUtils.equals(decodePassword, rawPassword);
    }

    /**
     * 是否为管理员
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }
}

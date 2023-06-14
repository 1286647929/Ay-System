package com.ay.common.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.ay.common.annotation.Log;
import com.ay.common.constant.HttpStatus;
import com.ay.common.core.domain.entity.SysUser;
import com.ay.common.core.domain.model.LoginUser;
import com.ay.common.exception.ServiceException;
import com.ay.common.utils.sign.RSA;
import com.ay.web.service.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 安全服务工具类
 * 
 * @author ruoyi
 */
@Component
public class SecurityUtils {

    @Autowired
    private AuthUser authUser;

    /**
     * 用户ID
     **/
    public static Long getUserId()
    {
        try
        {
            return getLoginUser().getUserId();
        }
        catch (Exception e)
        {
            throw new ServiceException("获取用户ID异常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 获取部门ID
     **/
    public static Long getDeptId()
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
            return getLoginUser().getUsername();
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
            LoginUser loginUser = new LoginUser();
            SysUser user = authUser.getLoginUser(Long.valueOf(String.valueOf(StpUtil.getTokenInfo().getLoginId())));
            loginUser.setUserId(user.getUserId());
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

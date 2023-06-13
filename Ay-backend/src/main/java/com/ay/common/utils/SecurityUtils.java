package com.ay.common.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.ay.common.exception.ServiceException;
import com.ay.entity.SysUser;
import com.ay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 安全服务工具类
 *
 * @author campus
 */
@Component
public class SecurityUtils {

    @Autowired
    private UserService userService;

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
     * 获取用户账户
     **/
    public String getUsername()
    {
        try
        {
            return getLoginUser().getUserName();
        }
        catch (Exception e)
        {
            throw new ServiceException("获取用户账户异常", HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * 获取用户
     **/
    public SysUser getLoginUser()
    {
        try
        {
            System.out.println(StpUtil.getTokenInfo().getLoginId());
            return userService.findUserById(Integer.valueOf(String.valueOf(StpUtil.getTokenInfo().getLoginId())));
        }
        catch (Exception e)
        {
            throw new ServiceException("获取用户信息异常", HttpStatus.UNAUTHORIZED);
        }
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

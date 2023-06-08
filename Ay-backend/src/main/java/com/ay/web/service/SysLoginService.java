package com.ay.web.service;

import cn.dev33.satoken.stp.StpUtil;
import com.ay.common.core.redis.RedisCache;
import com.ay.common.exception.user.UserUserNameOrPasswordNotMatchException;
import com.ay.common.utils.sign.RSA;
import com.ay.entity.SysUser;
import com.ay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysLoginService {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisCache redisCache;
    /**
     *
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public String login(String username, String password,String code,String uuid){
        //用户验证
        String decryptpassword = RSA.rsaDecryptByPrivate(password);
        SysUser sysUser = userService.authenLogin(username, decryptpassword);
        if(sysUser!=null){
            StpUtil.login(sysUser.getUserId());
            String tokenValue = StpUtil.getTokenValue();
            return tokenValue;
        }else {
            throw new UserUserNameOrPasswordNotMatchException();
        }
    }
}

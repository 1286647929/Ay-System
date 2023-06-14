package com.ay.web.service;

import cn.dev33.satoken.stp.StpUtil;
import com.ay.common.constant.CacheConstants;
import com.ay.common.core.redis.RedisCache;
import com.ay.common.exception.user.CaptchaException;
import com.ay.common.exception.user.CaptchaExpireException;
import com.ay.common.exception.user.UserPasswordNotMatchException;
import com.ay.common.utils.sign.RSA;
import com.ay.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysLoginService {
    @Autowired
    private ISysUserService ISysUserService;

    @Autowired
    private RedisCache redisCache;
    /**
     *
     * @param userName 用户名
     * @param password 密码
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public String login(String userName, String password,String code,String uuid){
        //校验验证码
//        validateCaptcha(userName, code, uuid);

        //用户验证
        SysUser sysUser = ISysUserService.authenLogin(userName);
        if(sysUser!=null){
            String decryptPassword = RSA.rsaDecryptByPrivate(sysUser.getPassword());
            if (password.equals(decryptPassword)){
                StpUtil.login(sysUser.getUserId());
                return StpUtil.getTokenValue();
            }else {
                throw new UserPasswordNotMatchException();
            }
        }else {
            throw new UserPasswordNotMatchException();
        }
    }


    /**
     * 校验验证码
     *
     * @param username 用户名
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public void validateCaptcha(String username, String code, String uuid)
    {
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null)
        {
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha))
        {
            throw new CaptchaException();
        }
    }
}

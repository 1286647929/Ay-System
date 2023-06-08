package com.ay.common.exception.user;

/**
 * 用户密码不正确或不符合规范异常类
 * 
 * @author campus
 */
public class UserUserNameOrPasswordNotMatchException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserUserNameOrPasswordNotMatchException()
    {
        super("user.username.Or.password.not.match", null);
    }
}

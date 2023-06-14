package com.ay.web.service;

import com.ay.entity.SysUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuthUser {

    @Autowired
    private ISysUserService ISysUserService;

    /**
     * 获取登录用户
     * @param userId
     * @return
     */
    public SysUser getLoginUser(Integer userId) {
        return ISysUserService.findUserById(userId);
    }
}

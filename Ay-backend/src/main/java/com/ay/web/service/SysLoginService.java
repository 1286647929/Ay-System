package com.ay.web.service;

import com.ay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysLoginService {
    @Autowired
    private UserService userService;

    public String login(String username, String password,String code,String uuid){

        return null;
    }
}

package com.ay.controller;

import com.ay.common.constant.Constants;
import com.ay.common.core.domain.AjaxResult;
import com.ay.common.core.domain.model.LoginBody;
import com.ay.service.UserService;
import com.ay.web.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    private SysLoginService loginService;

    @Autowired
    private UserService userService;

    @GetMapping("/test/{userid}")
    public AjaxResult test(@PathVariable("userid") Integer id){
//        try {
////            StpUtil.checkLogin();
//        }catch (Exception e){
//
//        }
        return AjaxResult.success(userService.findUserById(id));
    }

    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody){
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }
}

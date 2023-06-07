package com.ay.controller;

import com.ay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

//    @PostMapping("/login")
//    public AjaxResult test(@PathVariable("userid") Integer id){
//        try {
//            StpUtil.checkLogin();
//        }catch (Exception e){
//            return
//        }
//        SysUser User = userService.findUserById(id);
//    }
}

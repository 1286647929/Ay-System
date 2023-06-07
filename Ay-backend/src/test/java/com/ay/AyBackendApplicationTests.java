package com.ay;

import com.ay.entity.SysUser;
import com.ay.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AyBackendApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("123456"));
    }

    @Test
    public void test(){
//        List<SysUser> sysUsers = userService.findAll();
        SysUser sysUsers = userService.findUserById(1);
        System.out.println("测试结果"+sysUsers);
//        userService.getById(1);
    }

}
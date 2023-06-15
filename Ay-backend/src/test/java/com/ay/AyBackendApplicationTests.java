package com.ay;

import com.ay.common.core.domain.entity.SysUser;
import com.ay.common.utils.sign.RSA;
import com.ay.system.service.ISysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AyBackendApplicationTests {
    @Autowired
    private ISysUserService userService;

    @Test
    void contextLoads() throws Exception {
        String s = RSA.rsaEncryptByPublic("123456");
        System.out.println(s);

        String s1 = RSA.rsaDecryptByPrivate(s);
        System.out.println(s1);
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("123456"));
        // 生成一对公钥和私钥，其中Map对象 (private=私钥, public=公钥)
//        System.out.println(SaSecureUtil.rsaGenerateKeyPair());
    }

    @Test
    public void test(){
//        List<SysUser> sysUsers = userService.findAll();
        SysUser sysUsers = userService.selectUserById(1L);
        System.out.println("测试结果"+sysUsers);
//        userService.getById(1);
    }

}
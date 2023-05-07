package com.ay.service;

import com.ay.entity.SysUser;
import com.ay.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author WuDa
 * @data 2023/5/5
 **/
@Service
public class AuthorizeService implements UserDetailsService {

    @Resource
    private UserMapper userMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null){
            throw new UsernameNotFoundException("用户名不能为空");
        }
        SysUser user = userMapper.findUserByNameOrEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        return User
                .withUsername(user.getUserName())
                .password(user.getPassword())
                .roles("user")
                .build();
    }
}
package com.ay.service.impl;

import com.ay.entity.SysUser;
import com.ay.mapper.UserMapper;
import com.ay.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<SysUser> findAll() {
        return userMapper.findAll();
    }

    @Override
    public SysUser findUserById(Integer id) {
        return userMapper.getByUserId(id);
    }

    @Override
    public SysUser authenLogin(String userName) {
        return userMapper.getUserByUserNameAndPassword(userName);
    }

}

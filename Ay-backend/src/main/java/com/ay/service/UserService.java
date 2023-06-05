package com.ay.service;

import com.ay.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UserService extends IService<SysUser> {
    List<SysUser> findAll();
}
package com.ay.mapper;

import com.ay.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author WuDa
 * @data 2023/5/5
 **/
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
    List<SysUser> findAll();

}
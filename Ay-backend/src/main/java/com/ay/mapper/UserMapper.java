package com.ay.mapper;

import com.ay.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author WuDa
 * @data 2023/5/5
 **/
@Mapper
public interface UserMapper extends BaseMapper<SysUser> {
    List<SysUser> findAll();

    SysUser getByUserId(@Param("id") Integer id);

    SysUser getUserByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

}
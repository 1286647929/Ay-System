package com.ay.mapper;

import com.ay.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author WuDa
 * @data 2023/5/5
 **/
@Mapper
public interface UserMapper {
    @Select("select * from sys_user where user_name = #{text} or email = #{text}")
    SysUser findUserByNameOrEmail(String text);
}
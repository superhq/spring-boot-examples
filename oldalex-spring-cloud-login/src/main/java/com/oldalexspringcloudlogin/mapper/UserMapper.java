package com.oldalexspringcloudlogin.mapper;


import com.oldalexspringcloudlogin.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();
    @Select("select password from user where name=#{name}")
    String getPassword(String name);
}

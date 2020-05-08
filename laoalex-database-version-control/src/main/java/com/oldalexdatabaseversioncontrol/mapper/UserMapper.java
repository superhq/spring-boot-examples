package com.oldalexdatabaseversioncontrol.mapper;

import com.oldalexdatabaseversioncontrol.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Select("select * from user")
    List<User> getAll();
}

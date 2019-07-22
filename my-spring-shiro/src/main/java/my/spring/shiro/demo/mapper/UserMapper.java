package my.spring.shiro.demo.mapper;

import my.spring.shiro.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from users ")
    List<User> getAllUser();
}

package my.spring.shiro.demo.mapper;

import my.spring.shiro.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    @Select("select * from users")
    @Results({@Result(id = true, column = "id", property = "id"),
            @Result(column = "name", property = "name"),
            @Result(column = "password", property = "password"),
            @Result(column = "id", property = "roles",
                    many = @Many(select = "my.spring.shiro.demo.mapper.RoleMapper.getRolesByUserId"))})
    List<User> getAllUser();

    @Select("select * from users where id=#{id}")
    @Results(
            {@Result(column = "id", property = "roles",
                    many = @Many(select = "my.spring.shiro.demo.mapper.RoleMapper.getRolesByUserId"))})
    User getUserById(int id);

    @Select("select * from users where name=#{name}")
    @Results(
            {@Result(column = "id", property = "roles",
                    many = @Many(select = "my.spring.shiro.demo.mapper.RoleMapper.getRolesByUserId"))})
    User getUserByName(String name);
}

package my.spring.shiro.demo.mapper;

import my.spring.shiro.demo.model.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleMapper {
    @Select("select * from roles where id=#{id}")
    @Results({
            @Result(property = "perms", column = "id",
                    many = @Many(select = "my.spring.shiro.demo.mapper.PermMapper.getPermsByRoleId",
                            fetchType = FetchType.LAZY)
            )
    })
    Role getRoleById(int id);

    @Select("select * from roles where id in (select rid from user_role where uid=#{id})")
    @Results({
            @Result(property = "perms", column = "id",
                    many = @Many(select = "my.spring.shiro.demo.mapper.PermMapper.getPermsByRoleId",
                            fetchType = FetchType.LAZY))
    })
    List<Role> getRolesByUserId(int id);
}

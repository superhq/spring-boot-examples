package my.spring.shiro.demo.mapper;

import my.spring.shiro.demo.model.Perm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PermMapper {
    @Select("select * from perms where id=#{id}")
    Perm getPermById(int id);

    @Select("select * from perms where id in (select pid from role_perm where rid=#{id})")
    List<Perm> getPermsByRoleId(int id);
}

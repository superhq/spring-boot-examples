package my.spring.shiro.demo;

import my.spring.shiro.demo.mapper.RoleMapper;
import my.spring.shiro.demo.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void getRoleById() {
        Role role = roleMapper.getRoleById(0);
        System.out.println(role.getName());
        System.out.println(role.getPerms());
    }

    @Test
    public void getRolesByUserId() {
        List<Role> roles = roleMapper.getRolesByUserId(1);
        System.out.println(roles);
    }
}

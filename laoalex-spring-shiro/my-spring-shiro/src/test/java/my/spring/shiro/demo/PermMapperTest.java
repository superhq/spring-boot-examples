package my.spring.shiro.demo;

import my.spring.shiro.demo.mapper.PermMapper;
import my.spring.shiro.demo.model.Perm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermMapperTest {
    @Autowired
    private PermMapper permMapper;

    @Test
    public void getPermById() {
        Perm perm = permMapper.getPermById(0);
        System.out.println(perm);
    }

    @Test
    public void getPermsByRoleId() {
        List<Perm> perms = permMapper.getPermsByRoleId(0);
        for (Perm perm : perms) {
            System.out.println(perm);
        }
    }

}

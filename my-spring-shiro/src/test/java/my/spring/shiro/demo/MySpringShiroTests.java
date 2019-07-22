package my.spring.shiro.demo;

import my.spring.shiro.demo.mapper.UserMapper;
import my.spring.shiro.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySpringShiroTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getAllUsers()
    {
        List<User> users = userMapper.getAllUser();
        for(User user : users){
            System.out.println(user);
        }
    }

}

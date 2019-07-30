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
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAllUsers(){
        List<User> users = userMapper.getAllUser();
        System.out.println(users);
    }

    @Test
    public void getUserById(){
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void getUserByName(){
        User user = userMapper.getUserByName("hongqun");
        System.out.println(user);
    }
}

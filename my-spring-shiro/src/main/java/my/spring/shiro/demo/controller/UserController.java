package my.spring.shiro.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/test")
    public String hello() {
        return "test";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/add")
    public String add() {
        return "add";
    }

    @RequestMapping("/del")
    public String del() {
        return "del";
    }
}

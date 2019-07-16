package my.spring.shiro.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(HttpServletRequest request, Model model){
        if(request.getMethod().equals("GET")) {
            return "login";
        }
        else{
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(request.getParameter("user"),request.getParameter("password"));
            try {
                subject.login(token);
            }catch (AuthenticationException e){
                model.addAttribute("msg","登录出错:" + e.getMessage());
                return "login";

            }
            return "redirect:index";
        }
    }
}

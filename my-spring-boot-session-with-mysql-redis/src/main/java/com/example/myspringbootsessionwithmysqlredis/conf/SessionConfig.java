package com.example.myspringbootsessionwithmysqlredis.conf;

import com.alibaba.fastjson.JSON;
import com.example.myspringbootsessionwithmysqlredis.common.BaseResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Security;

@Configuration
public class SessionConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SecurityInterceptor())
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/logout")
                .addPathPatterns("/user/**");
    }
}

@Configuration
class SecurityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.isNew()) {
            session.invalidate();
            response.getWriter().write(JSON.toJSONString(new BaseResponse(-1, "please login first")));
        } else {
            return true;
        }
        return false;
    }
}

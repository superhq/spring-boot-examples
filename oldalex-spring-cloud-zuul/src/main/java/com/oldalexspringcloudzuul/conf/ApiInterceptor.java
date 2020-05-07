package com.oldalexspringcloudzuul.conf;

import com.alibaba.fastjson.JSON;
import com.oldalexspringcloudzuul.common.BaseResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class ApiInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("in api interceptor");
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

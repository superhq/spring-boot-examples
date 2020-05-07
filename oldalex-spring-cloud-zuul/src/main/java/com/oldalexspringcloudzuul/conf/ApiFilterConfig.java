package com.oldalexspringcloudzuul.conf;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.oldalexspringcloudzuul.common.BaseResponse;
import org.apache.http.protocol.ResponseContent;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;



@Configuration
public class ApiFilterConfig extends ZuulFilter {


    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.reg
        return true;
    }



    @Override
    public Object run() throws ZuulException {
        System.out.println("in api filter......");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        HttpSession session = request.getSession();
        if (session.isNew()) {
            session.invalidate();
            //不要进行转发
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseBody(JSON.toJSONString(new BaseResponse(-1, "please login first")));
            return null;
        } else {
            return null;
        }

    }
}


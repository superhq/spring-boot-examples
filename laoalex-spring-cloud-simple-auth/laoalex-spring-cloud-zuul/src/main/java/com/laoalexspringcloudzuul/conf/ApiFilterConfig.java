package com.laoalexspringcloudzuul.conf;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.laoalexspringcloudzuul.common.BaseResponse;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        if (ctx.getRequest().getRequestURI().equals("/auth/login"))
            return false;

        return true;
    }


    @Override
    public Object run() throws ZuulException {
        //System.out.println("in api filter......");
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


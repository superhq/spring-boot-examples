package com.oldalexspringcloudzuul.conf;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ApiInterceptorConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private ApiInterceptor apiInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiInterceptor)
                .excludePathPatterns("/auth/login")
                .excludePathPatterns("/auth/logout")
                .addPathPatterns("/api/*");
    }
}

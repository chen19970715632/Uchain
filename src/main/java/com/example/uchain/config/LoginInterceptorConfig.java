package com.example.uchain.config;

import com.example.uchain.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns拦截的路径
        String[] addPathPatterns = {
                "/**"
        };

        //excludePathPatterns排除的路径
        String[] excludePathPatterns = {
                "/login",
                "/members",
                "/information"
        };

        //创建用户拦截器对象并指定其拦截的路径和排除的路径
        registry.addInterceptor(new LoginCheckInterceptor())
                .addPathPatterns(addPathPatterns)
                .excludePathPatterns(excludePathPatterns);
    }
}

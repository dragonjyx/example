package com.example.validate;

import com.example.validate.Interceptor.AuthenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description TODO
 * @date 2020/1/20 15:44
 * @blame 仓储开发组
 **/
@Configuration
public class AdminWebMvcConfig   extends WebMvcConfigurationSupport {

    @Bean
    public AuthenInterceptor authenInterceptor(){
        return new AuthenInterceptor();
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenInterceptor());
        super.addInterceptors(registry);
    }
}

package com.example.validate;

import com.example.validate.response.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author oyxl 10071355
 * @version 1.0
 * @description TODO
 * @date 2020/1/20 15:19
 * @blame 仓储开发组
 **/
@Configuration
public class AppConfig {

    @Value("${myUserName}")
    private String userName;

    @Bean
    public UserInfo getUserInfo(){
        UserInfo userInfo =  new UserInfo(userName,20,1,"大学生");
        return userInfo;
    }


}

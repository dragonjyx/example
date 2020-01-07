package com.example.validate.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.validate.request.UserInfoPage;
import com.example.validate.request.UserLogin;
import com.example.validate.response.UserInfo;
import com.example.validate.util.ValidationUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Api(value = "登录模块",tags = "用户登录")
@Slf4j
@RestController
@RequestMapping("/")
public class LoginController {


    @ApiOperation(value = "用户登录")
    @ApiResponses({
            @ApiResponse(code = 0,message = "登录成功"),
            @ApiResponse(code = -1,message = "登录失败")
    })
    @PostMapping("dologin")
    public JSONObject doLogin(UserLogin userLogin){

        ValidationUtils.validate(userLogin);

        String token = UUID.randomUUID().toString();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("token",token);
        return jsonObject;
    }


    @ApiOperation(value = "用户信息")
    @GetMapping("user-info")
    public UserInfo getUserInfo(){
        return new UserInfo("小明",20,1,"大学生");
    }


    @ApiOperation(value = "用户分页查询")
    @PostMapping("user/page")
    public JSONObject userPage(UserInfoPage userInfoPage){

        ValidationUtils.validate(userInfoPage);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",0);
        jsonObject.put("userInfoPage",userInfoPage);
        return jsonObject;
    }







}

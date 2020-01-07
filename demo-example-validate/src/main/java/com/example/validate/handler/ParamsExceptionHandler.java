package com.example.validate.handler;

import com.example.validate.response.BaseResp;

/**
 * @description:参数异常
 * @athoor: DRAGON-Yeah
 * @date: 2019/8/5 22:36
 */
public abstract class ParamsExceptionHandler {

    public BaseResp handler(Exception e){
        return new BaseResp("0","异常","","");
    }

}

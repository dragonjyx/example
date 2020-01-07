package com.example.validate.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;


@ApiModel("登录请求")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin implements Serializable {


    private static final long serialVersionUID = -6560532892165437435L;


    @NotNull(message = "请输入登录账号")
    @ApiModelProperty(value = "登录账号",required = true)
    private String account;

    @NotNull(message = "请输入登录密码")
    @ApiModelProperty(value = "登录密码",required = true)
    private String password;

    @ApiModelProperty(value = "登录类型",required = true)
    private String type;


}

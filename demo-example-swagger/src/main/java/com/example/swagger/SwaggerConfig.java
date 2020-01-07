package com.example.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collection;


/**
 * swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket ProductApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/demo")
                .select()
                .build()
                .apiInfo(productApiInfo());
    }


    private ApiInfo productApiInfo(){
        Contact contact = new Contact("testEmail","mail.qq.com","674806334@qq.com");
        Collection<VendorExtension> vendorExtensions = new ArrayList<>();
        ApiInfo apiInfo = new ApiInfo(
                "demo系统数据接口文档",
                "demo文档描述",
                "1.0.0",
                "API TERMS URL",
                contact,
                "license",
                "license url",
                vendorExtensions
        );
        return apiInfo;
    }



}

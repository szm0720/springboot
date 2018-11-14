package com.me.config;

import com.spring4all.swagger.EnableSwagger2Doc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: ybbdhfhv
 * @Date: 2018/7/5 09:58
 * @Description:
 */
@Configuration
@EnableSwagger2Doc
@Slf4j
@ConditionalOnProperty(name = "swagger.enable",havingValue = "true")
public class SwaggerConfig {

    @Value("${spring.cloud.config.profile}")
    private String env;

    @Bean
    public Docket createRestApi(){
        log.info("加载Swagger[{}]...",env);
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("firmiana")
                .apiInfo(new ApiInfoBuilder().title("梧桐车服 - 认证服务["+env+"环境]").version("1.0.0").build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.firmiana.auth.controller"))
                .build();
    }

}

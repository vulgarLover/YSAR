package com.ysar.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author shenwei
 * @version 1.0
 * @date 2019/8/3 19:18
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 文档标题
     */
    @Value("${swagger.title}")
    private String title;

    /**
     * 文档描述
     */
    @Value("${swagger.description}")
    private String description;

    /**
     * api版本
     */
    @Value("${swagger.version}")
    private String version;

    /**
     * baseService url
     */
    @Value("${swagger.serviceUrl}")
    private String serviceUrl;

    /**
     * controller 包路径
     */
    @Value("${swagger.package}")
    private String swaggerPackage;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 为扫描包路径
                .apis(RequestHandlerSelectors.basePackage(swaggerPackage))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                //服务网址
                .termsOfServiceUrl(serviceUrl)
                .version(version)
                //.contact(new Contact("hello", "url", "email"))
                .build();
    }
}

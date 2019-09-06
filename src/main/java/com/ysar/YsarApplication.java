package com.ysar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shenwei
 * @version 1.0
 * @date 2019/7/17 9:56
 */
@SpringBootApplication
@MapperScan("com.ysar.module.*.mapper")
public class YsarApplication {
    public static void main(String[] args) {
        SpringApplication.run(YsarApplication.class, args);
    }
}
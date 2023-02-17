package com.soil.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

//Feign集成Riboon 和 Eureka 整合后，客户端可以通过api直接调用
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.soil.springcloud"})//扫描包下的注解
@ComponentScan("com.soil.springcloud")//扫描自己的注解
public class FeignDeptConsumerApplication {

    public static void main(String[] args){
        SpringApplication.run(FeignDeptConsumerApplication.class,args);
    }
}

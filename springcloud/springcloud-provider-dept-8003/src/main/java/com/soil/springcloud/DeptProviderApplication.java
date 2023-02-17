package com.soil.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //自动注册到Eureka
@EnableDiscoveryClient  //服务发现
public class DeptProviderApplication {

    public static void main(String[] args){
        SpringApplication.run(DeptProviderApplication.class,args);
    }
}

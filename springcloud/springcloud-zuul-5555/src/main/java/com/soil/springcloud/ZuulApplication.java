package com.soil.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//Riboon 和 Eureka 整合后，客户端可以直接调用，不用关心IP地址和端口号
@SpringBootApplication
@EnableZuulProxy  //代理
public class ZuulApplication {

    public static void main(String[] args){
        SpringApplication.run(ZuulApplication.class,args);
    }
}

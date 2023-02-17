package com.soil.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
//Riboon 和 Eureka 整合后，客户端可以直接调用，不用关心IP地址和端口号
@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumerDashboardApplication {

    public static void main(String[] args){
        SpringApplication.run(DeptConsumerDashboardApplication.class,args);
    }
}

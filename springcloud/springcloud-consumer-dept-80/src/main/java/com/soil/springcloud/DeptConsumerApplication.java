package com.soil.springcloud;

import com.soil.myrule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

//Riboon 和 Eureka 整合后，客户端可以直接调用，不用关心IP地址和端口号
@SpringBootApplication
@EnableEurekaClient
//微服务启动时加载Ribbon自定义
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyRule.class)
public class DeptConsumerApplication {

    public static void main(String[] args){
        SpringApplication.run(DeptConsumerApplication.class,args);
    }
}

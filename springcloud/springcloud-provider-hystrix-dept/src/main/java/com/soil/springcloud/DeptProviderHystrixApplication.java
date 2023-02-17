package com.soil.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient //自动注册到Eureka
@EnableDiscoveryClient  //服务发现
@EnableCircuitBreaker //添加对熔断的支持
public class DeptProviderHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeptProviderHystrixApplication.class, args);
    }

    //增加一个servlet,服务监控
    @Bean
    public ServletRegistrationBean hystrixmetricsstreamservlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
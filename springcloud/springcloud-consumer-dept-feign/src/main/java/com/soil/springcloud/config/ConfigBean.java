package com.soil.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {//@Configuration -- spring applicationContext.xml
//配置负载均衡实现RestTemplate
    //IRule
    //RoundRobinRule 轮询 默认
    //RandomRule 随机
    //AvailabilityFilteringRule : 会先 过滤掉，跳闸，访问故障的服务~，对剩下的进行轮询
//RetryRule 先轮询，如果获取失败，会在指定的时间内进行重试
    @Bean
    @LoadBalanced //Ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //算法自定义
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}

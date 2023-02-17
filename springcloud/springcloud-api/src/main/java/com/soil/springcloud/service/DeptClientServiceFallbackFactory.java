package com.soil.springcloud.service;

import com.soil.springcloud.service.model.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//服务降级
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean addDetp(Dept dept) {
                return false;
            }

            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("id=>"+id+",没有客户信息，客户端提供了降级的信息，这个服务现在已被关闭")
                        .setDb_source("no this database in MySQL");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}

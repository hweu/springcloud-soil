//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.soil.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SoilRandomRule extends AbstractLoadBalancerRule {
    public SoilRandomRule() {
    }

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;
//默认的随机算法
            while(server == null) {
                if (Thread.interrupted()) {//查看是否中断
                    return null;
                }

                List<Server> upList = lb.getReachableServers();//活着的服务
                List<Server> allList = lb.getAllServers();//获取所有的服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                int index = this.chooseRandomInt(serverCount);//生成区间随机数
                server = (Server)upList.get(index);//从活着的服务中随机获取一个
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}

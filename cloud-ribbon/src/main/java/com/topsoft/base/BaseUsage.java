package com.topsoft.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.net.URI;

/**
 * @author guokaige
 * @version
 */
public class BaseUsage {

    @Autowired
    private LoadBalancerClient loadBalancer;

    public void doStuff() {
        //拿到负载均衡访问的服务instance-server
        ServiceInstance instance = loadBalancer.choose("instance-server");
        URI storesUri = URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
        // ... do something with the URI
    }
}

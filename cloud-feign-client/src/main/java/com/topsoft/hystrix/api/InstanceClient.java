package com.topsoft.hystrix.api;



import com.topsoft.Instance;
import com.topsoft.hystrix.failback.InstanceClientFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 指定远端服务instance-server , 调用远端服务api: /instance/{serviceId}
 */
@FeignClient(value = "instance-server", fallback = InstanceClientFallBack.class)
public interface InstanceClient {

    @RequestMapping(value = "/instance/{serviceId}", method = RequestMethod.GET)
    public Instance getInstanceByServiceId(@PathVariable("serviceId") String serviceId);
}

package com.topsoft.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.topsoft.Instance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xuan on 2018/3/9.
 */
@Service
public class InstanceService {

    private static Logger logger = LoggerFactory.getLogger(InstanceService.class);

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "instanceInfoGetFail",
            threadPoolProperties = {
                    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true"),
                    @HystrixProperty(name = "maximumSize", value = "20")
            }

    )
    public Instance getInstanceByServiceIdWithRestTemplate(String serviceId) {
        Instance instance = restTemplate.getForEntity("http://instance-server/instance/{serviceId}", Instance.class, serviceId).getBody();
        return instance;
    }

    private Instance instanceInfoGetFail(String serviceId) {
        logger.info("Can not get Instance by serviceId {}", serviceId);
        return new Instance("error", "error", 0);
    }

}

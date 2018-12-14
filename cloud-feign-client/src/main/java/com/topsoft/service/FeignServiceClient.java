package com.topsoft.service;


import com.topsoft.Instance;
import com.topsoft.hystrix.api.InstanceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class FeignServiceClient {

    @Autowired
    InstanceClient instanceClient;
    /**
     * 调用远端api
     * @param serviceId
     * @return
     */
    public Instance getInstanceByServiceIdWithFeign(String serviceId) {
        Instance instance = instanceClient.getInstanceByServiceId(serviceId);
        return instance;
    }

}

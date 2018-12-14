package com.topsoft.web;


import com.topsoft.Instance;
import com.topsoft.service.FeignServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xuan on 2018/2/3.
 */
@RestController
@RequestMapping("/feign-client")
public class FeignClientController {

    @Autowired
    FeignServiceClient feignServiceClient;

    @RequestMapping(value = "/instance/{serviceId}", method = RequestMethod.GET)
    public Instance getInstanceByServiceId(@PathVariable("serviceId") String serviceId) {
        return feignServiceClient.getInstanceByServiceIdWithFeign(serviceId);
    }


}

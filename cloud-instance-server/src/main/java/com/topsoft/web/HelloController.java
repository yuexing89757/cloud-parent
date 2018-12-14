package com.topsoft.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guokaige
 * @date 2018/12/14 13:53
 */

@RestController
public class HelloController {


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String createInstance() {
        return "早上好,";
    }
}

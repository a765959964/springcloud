package com.zf.service;

import com.zf.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 张帆
 * @create: 2019-06-03 10:27
 * @Description:
 **/
@RequestMapping("/refactor")
public interface HelloService {


    @RequestMapping(value = "/hello4" , method =  RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello5" ,method =  RequestMethod.GET)
    User hello(@RequestHeader("name") String name,@RequestHeader("address") String address);

    @RequestMapping(value = "/hello6" , method =  RequestMethod.POST)
    @ResponseBody
    String hello(User user);

}

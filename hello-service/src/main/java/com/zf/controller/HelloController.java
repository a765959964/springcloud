package com.zf.controller;

import com.zf.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 张帆
 * @create: 2019-05-29 11:44
 * @Description: 服务提供者
 **/
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public  String index() throws InterruptedException {

//        int  sleepTime = new Random().nextInt(3000);
//        logger.info("sleepTime:" + sleepTime);
//        Thread.sleep(sleepTime);
        logger.info("/hello,Service,服务提供者");
        return "Hello Word";
    }


    @RequestMapping(value = "/hello1" , method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello " + name;
    }

    @RequestMapping (value = "/hello2" ,method =  RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader String address){
        return new User(name,address);
    }

    @RequestMapping(value = "/hello3" , method =  RequestMethod.POST)
    @ResponseBody
    public String hello(User user){
        return "Hello" + user.getAddress() + user.getName();
    }

}

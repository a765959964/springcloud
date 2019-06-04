package com.zf.controller;

import com.zf.model.User;
import com.zf.service.HelloService1;
import com.zf.service.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 实现对Feign 客户端的调用
 * @author: 张帆
 * @create: 2019-05-30 17:01
 * @Description:
 **/
@RestController
public class ConsumerController {

    // 注入
    @Autowired
    HelloService1 helloService;

    @Autowired
    RefactorHelloService refactorHelloService;


    @RequestMapping(value="/feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping(value = "/feign-consumer2",method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\n");
        sb.append(helloService.hello("didi")).append("\n");
        sb.append(helloService.hello("didi","123123")).append("\n");
        sb.append(helloService.hello(new User("didi","123312"))).append("\n");
        return sb.toString();
    }

    @RequestMapping(value = "/feign-consumer3",method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append(refactorHelloService.hello("gege")).append("\n");
        sb.append(refactorHelloService.hello("gege","213")).append("\n");
        sb.append(refactorHelloService.hello(new com.zf.dto.User("gege","213"))).append("\n");
        return sb.toString();
    }

}
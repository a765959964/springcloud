package com.zf.service;

import com.zf.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 定义 service 接口
 * @author: 张帆
 * @create: 2019-05-30 16:58
 * @Description: 通过@FeignClient 注解指定服务名来绑定服务
 **/
@FeignClient("hello-service")
public interface HelloService1 {

    @RequestMapping("/hello")
    String hello();


    @RequestMapping(value="hello1",method = RequestMethod.GET)
    String hello(@RequestParam("name") String name);

    @RequestMapping(value="hello2",method = RequestMethod.GET)
    User hello(@RequestHeader("name") String name, @RequestHeader("address") String address);

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    @ResponseBody
    String hello(User user);
}

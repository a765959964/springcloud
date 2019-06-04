package com.zf.controller;

import com.zf.dto.User;
import com.zf.service.HelloService;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 张帆
 * @create: 2019-06-03 10:35
 * @Description:
 **/
@RestController
public class RefactorHelloController implements HelloService {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello" + name;
    }

    @Override
    public User hello(@RequestHeader(value = "name") String name, @RequestHeader(value =  "address") String address) {
        return new User(name,address);
    }

    @Override
    @ResponseBody
    public String hello( User user) {
        return "Hello " + user.getName();

    }
}

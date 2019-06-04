package com.zf.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: 张帆
 * @create: 2019-05-30 9:49
 * @Description:
 **/
@Service
public class HelloService {

    private static Logger logger  = LoggerFactory.getLogger(HelloService.class);

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback",commandKey = "helloKey")
    public String helloService(){
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello",String.class).getBody();
    }

    public String helloFallback(){
        long start   = System.currentTimeMillis();
        long end =  System.currentTimeMillis();
        logger.info("Spend time : " + (end - start));
        return "error";
    }
}

package com.zf.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: 张帆
 * @create: 2019-06-03 10:41
 * @Description:
 **/
@FeignClient(value = "HELLO-SERVICE")
public interface RefactorHelloService  extends HelloService {
}

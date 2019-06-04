package com.zf.controller;

import com.zf.model.User;
import com.zf.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: 张帆
 * @create: 2019-05-29 14:21
 * @Description: 服务消费者
 **/
@RestController
public class CustomerController {

    @Autowired
    HelloService helloService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value="/ribbon-consumer",method = RequestMethod.GET)
    public String helloCustomer(){
//        return restTemplate.getForObject("http://HELLO-SERVICE/hello",String.class);
          return helloService.helloService();
    }


    /**
     *  1. getForEntity 的用法 传递 string
     *  2. 传递 user 对象
     *  3. 使用 map类型
     *  4. 使用URI 对象来替代之前的url 和 urlVariables
     * @return
     */
    public String getForEntity(){

        // 其中第三个参数 “didi” 会替换url 中的 {1} 占位符
        //1
        ResponseEntity<String> responseEntity =  restTemplate.getForEntity("http://HELLO-SERVICE/user?name={1}",String.class,"didi");
        //2
        ResponseEntity<User> responseEntity1 = restTemplate.getForEntity("http://HELLO-SERVICE/user?name={1}", User.class, "didi");
        Map params = new HashMap();
        params.put("name","didi");
        //3
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://HELLO-SERVICE/user?name={name}", String.class, params);

        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://HELLO-SERVICE/user?name={name}")
                .build().expand("dodo").encode();
        URI uri =  uriComponents.toUri();
        ResponseEntity<String> forEntity1 = restTemplate.getForEntity(uri, String.class);

        return responseEntity.getBody();
    }


    /**
     * 该方法 可以理解为 getForEntity 的封装
     * @return
     */
    public String getForObject(){

        return null;
    }

    /**
     * post 提供请求
     * @return
     */
    public String postForEntity(){
        User user = new User(1,"didi");
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://HELLO-SERVICE/user", user, String.class);

        return responseEntity.getBody();
    }


}

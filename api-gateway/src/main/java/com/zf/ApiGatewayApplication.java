package com.zf;

import com.zf.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 *
 * 使用 @EnableZuulProxy 注解开启 Zuul 的api网关服务功能
 */
@EnableZuulProxy
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	//创建具体的bean 才能启动该过滤器
	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}


}

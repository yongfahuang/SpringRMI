package com.xmy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.xmy.service.TestService;

@SpringBootApplication
@PropertySource(value = { "classpath:application.properties", "classpath:global.properties" })
public class SpringBootRmiApplication {

	@Value("${serviceUrl}")
	private String serviceUrl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRmiApplication.class, args);
	}

	@Bean
	public RmiProxyFactoryBean rmiProxyFactoryBean() {
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		// 设置远程调用接口
		rmiProxyFactoryBean.setServiceUrl(serviceUrl);
		// 设置服务接口
		rmiProxyFactoryBean.setServiceInterface(TestService.class);
		return rmiProxyFactoryBean;
	}
}

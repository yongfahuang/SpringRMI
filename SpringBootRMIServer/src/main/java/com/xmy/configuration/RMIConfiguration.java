package com.xmy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.xmy.service.TestService;
import com.xmy.service.impl.TestServiceImpl;

@Configuration
public class RMIConfiguration {

	/**
	 * rmi 服务器暴漏 服务
	 * 
	 * @return
	 */
	@Bean
	public RmiServiceExporter rmiServiceExporter() {
		System.out.println("RMIConfiguration.rmiServiceExporter()");
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		TestService testService = new TestServiceImpl();
		// 客户端通过rmi调用的端口
		rmiServiceExporter.setRegistryPort(1010);
		// 客户端调用注册调用的服务名
		rmiServiceExporter.setServiceName("testService");
		// 注册的service
		rmiServiceExporter.setService(testService);
		// 注册的接口
		rmiServiceExporter.setServiceInterface(TestService.class);
		return rmiServiceExporter;
	}

}

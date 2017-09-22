package com.xmy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xmy.service.TestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRmiApplicationTests {

	@Autowired
	private TestService fileService;

	@Test
	public void contextLoads() {
		System.out.println(fileService);
	}

}

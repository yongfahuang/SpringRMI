package com.xmy.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xmy.service.TestService;

public class TestServiceImpl implements TestService {

	private static final Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

	@Override
	public String test(String name) {
		log.debug("TestServiceImpl.test()");
		return name + "使用者,你好";
	}

}

package com.green.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static ApplicationContext context;
	static {
		context = new ClassPathXmlApplicationContext("application.xml");
	}
	
	public static ApplicationContext getContext() {
		return context;
	}
}

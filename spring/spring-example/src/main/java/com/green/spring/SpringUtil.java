package com.green.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.green.spring.config.ApplicationConfig;

public class SpringUtil {
	private static ApplicationContext context;
	static {
//		context = new ClassPathXmlApplicationContext("application.xml");
		context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}
	
	public static ApplicationContext getContext() {
		return context;
	}
	
}

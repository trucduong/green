package com.green.spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.green.spring.HelloWorld;

@Configuration
//@ComponentScan("com.green.spring.dao")
public class ApplicationConfig {
	
	@Bean
	@Scope
	@Qualifier("helloWorld1")
	public HelloWorld getHelloWorld() {
		HelloWorld h = new HelloWorld();
		h.setMessage("Hello World!");
		
		return h;
	}
}

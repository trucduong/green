package com.green.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
//        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        
    	ApplicationContext context = SpringUtil.getContext();
    	
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        
    	System.out.println("Your message: " + obj.getMessage() );
    	
    	obj.setMessage("Hello Green!");
    	
    	
    	HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
    	System.out.println("Your message: " + obj1.getMessage() );
    	
    	
    	
    	HelloWorld obj2 = (HelloWorld) SpringUtil.getContext().getBean("helloWorld");
    }
}

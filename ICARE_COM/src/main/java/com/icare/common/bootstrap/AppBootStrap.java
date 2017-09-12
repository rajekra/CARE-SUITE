package com.icare.common.bootstrap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppBootStrap {

	public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppBootStrap.class);
        System.out.println("Container:"+context);
//        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
//        obj.printHelloWorld("Spring3 Java Config");

}
}

package com.example.firstSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.firstSpring.controller.MyController;

@SpringBootApplication
public class FirstSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringApplication.class, args);
//		 ApplicationContext cxt =  SpringApplication.run(FirstSpringApplication.class, args);
	
//	      MyController cont = cxt.getBean(MyController.class);
//	      
//	      System.out.println("in the main method");
//	      
//	      System.out.println(cont.getMSG());
	
	}

}

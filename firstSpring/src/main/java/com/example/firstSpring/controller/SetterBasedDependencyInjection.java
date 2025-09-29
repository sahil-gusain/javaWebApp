package com.example.firstSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.firstSpring.service.Greeting;
import com.example.firstSpring.service.GreetingIMPL;

@Controller
public class SetterBasedDependencyInjection {
     private Greeting greetingservice;
    
     @Autowired
	public void setGreetingservice(Greeting greetingservice) {
		this.greetingservice = greetingservice;
	}
     public String sayHello() {
    	 System.out.println("In the setter based injection");
    	  return greetingservice.getMsg();
     }
}

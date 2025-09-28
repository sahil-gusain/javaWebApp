package com.example.firstSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.firstSpring.service.GreetingIMPL;

@Controller
public class SetterBasedDependencyInjection {
     private GreetingIMPL greetingservice;
    
     @Autowired
	public void setGreetingservice(GreetingIMPL greetingservice) {
		this.greetingservice = greetingservice;
	}
     public String sayHello() {
    	 System.out.println("In the setter based injection");
    	  return greetingservice.getMsg();
     }
}

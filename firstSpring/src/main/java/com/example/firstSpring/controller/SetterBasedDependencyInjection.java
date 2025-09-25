package com.example.firstSpring.controller;

import com.example.firstSpring.service.GreetingIMPL;

public class SetterBasedDependencyInjection {
     private GreetingIMPL greetingservice;

	public void setGreetingservice(GreetingIMPL greetingservice) {
		this.greetingservice = greetingservice;
	}
     public String sayHello() {
    	 System.out.println("In the setter based injection");
    	  return greetingservice.getMsg();
     }
}

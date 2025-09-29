package com.example.firstSpring.controller;

import org.springframework.stereotype.Controller;

import com.example.firstSpring.service.Greeting;



@Controller
public class ConstructorBasedDependencyInjection {
   private final Greeting greetingservice;

  public ConstructorBasedDependencyInjection(Greeting greetingservice) {
	     this.greetingservice = greetingservice;
   }
   
  public String sayHello() {
	  System.out.println("In Constructor based dI");
	  return greetingservice.getMsg();
  }
}

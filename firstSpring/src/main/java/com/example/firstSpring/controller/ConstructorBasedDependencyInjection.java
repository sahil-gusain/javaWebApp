package com.example.firstSpring.controller;

import org.springframework.stereotype.Controller;

import com.example.firstSpring.service.GreetingIMPL;


@Controller
public class ConstructorBasedDependencyInjection {
   private final GreetingIMPL greetingservice;

  public ConstructorBasedDependencyInjection(GreetingIMPL greetingservice) {
	     this.greetingservice = greetingservice;
   }
   
  public String sayHello() {
	  System.out.println("In Constructor based dI");
	  return greetingservice.getMsg();
  }
}

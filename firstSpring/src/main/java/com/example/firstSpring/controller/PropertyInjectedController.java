package com.example.firstSpring.controller;

import com.example.firstSpring.service.GreetingIMPL;

public class PropertyInjectedController {
   GreetingIMPL greetingservice;
   
   public String sayHello() {
	   
	   System.out.println("In the property injected controller");
	   return greetingservice.getMsg();
   }
}

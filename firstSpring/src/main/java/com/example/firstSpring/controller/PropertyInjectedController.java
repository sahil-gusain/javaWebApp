package com.example.firstSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.firstSpring.service.GreetingIMPL;
@Controller
public class PropertyInjectedController {
   
	@Autowired
	GreetingIMPL greetingservice;
   
   public String sayHello() {
	   
	   System.out.println("In the property injected controller");
	   return greetingservice.getMsg();
   }
}

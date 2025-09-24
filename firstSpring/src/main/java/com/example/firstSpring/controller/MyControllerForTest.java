package com.example.firstSpring.controller;

import com.example.firstSpring.service.GreetingIMPL;

public class MyControllerForTest {
     private final GreetingIMPL greetingservice;
     
     public MyControllerForTest() {
    	 this.greetingservice =  new GreetingIMPL();
     }
     
     public String SayHello() {
    	 System.out.println("in the normal controller");
    	 
          return    	greetingservice.getMsg();
    }
}

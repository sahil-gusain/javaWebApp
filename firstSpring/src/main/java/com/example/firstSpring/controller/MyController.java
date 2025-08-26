package com.example.firstSpring.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
   
	public String getMSG() {
		
		System.out.println("in the controller");
		return "hello from controller";
	}
	 
}

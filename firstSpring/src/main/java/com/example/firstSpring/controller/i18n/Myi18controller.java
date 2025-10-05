package com.example.firstSpring.controller.i18n;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.firstSpring.service.Greeting;

@Controller
public class Myi18controller {
	
	Greeting greetingservice;

	public Myi18controller(@Qualifier("myi18") Greeting greetingservice) {
		this.greetingservice = greetingservice;
	}
	
	public String sayHello() {
		return greetingservice.getMsg();
	}
}

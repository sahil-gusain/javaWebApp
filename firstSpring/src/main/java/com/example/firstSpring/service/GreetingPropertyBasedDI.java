package com.example.firstSpring.service;

import org.springframework.stereotype.Service;

@Service("propertybased")
public class GreetingPropertyBasedDI implements Greeting {

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return "Property Based DI";
	}

}

package com.example.firstSpring.service;

import org.springframework.stereotype.Service;

@Service("SetterBased")
public class GreetingSetterBasedDI implements Greeting {

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return "IN the setterBased DI";
	}

}

package com.example.firstSpring.service;

import org.springframework.stereotype.Service;

@Service 
public class GreetingIMPL implements Greeting {

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return "hello welcome to the greeting";
	}

}

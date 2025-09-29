package com.example.firstSpring.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class GreetingPrimary implements Greeting {

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return "From the primary Bean";
	}

}

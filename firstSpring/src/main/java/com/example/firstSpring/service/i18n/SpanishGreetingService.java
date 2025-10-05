package com.example.firstSpring.service.i18n;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.firstSpring.service.Greeting;

@Profile("Spanish")
@Service("myi18")
public class SpanishGreetingService implements Greeting {

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return "IN the Spanish Service";
	}

}

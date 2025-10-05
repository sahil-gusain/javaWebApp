package com.example.firstSpring.service.i18n;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.example.firstSpring.service.Greeting;

//@Profile("default")
@Profile("EN")
@Service("myi18")
public class EnglishGreetingService implements Greeting {

	@Override
	public String getMsg() {
		// TODO Auto-generated method stub
		return "In the English Service";
	}

}

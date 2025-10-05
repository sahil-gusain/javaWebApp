package com.example.firstSpring.controller.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

//@ActiveProfiles("English")
@SpringBootTest
public class ControllerI18n {
     
	@Autowired
	Myi18controller myi18controller;
	
	
	@Test
	void sayHello() {
		System.out.println(myi18controller.sayHello());
	}
	
}

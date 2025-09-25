package com.example.firstSpring.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.firstSpring.service.GreetingIMPL;

class SetterBasedDependencyInjectionTest {
   
	 SetterBasedDependencyInjection setterinjectioncontroller;
	@BeforeEach
	void setUp() throws Exception {
		setterinjectioncontroller = new SetterBasedDependencyInjection();
		setterinjectioncontroller.setGreetingservice(new GreetingIMPL());
	}

	@Test
	void test() {
		System.out.println(setterinjectioncontroller.sayHello());
	}

}

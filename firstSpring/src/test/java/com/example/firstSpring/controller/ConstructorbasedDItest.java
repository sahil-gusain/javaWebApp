package com.example.firstSpring.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.firstSpring.service.GreetingIMPL;


@SpringBootTest
class ConstructorbasedDItest {
  
	@Autowired
	 ConstructorBasedDependencyInjection constructorbaseddependencyinjection;
//	@BeforeEach
//	void setUp() throws Exception {
//		constructorbaseddependencyinjection =new ConstructorBasedDependencyInjection(new GreetingIMPL());
//	}

	@Test
	void test() {
		System.out.println(constructorbaseddependencyinjection.sayHello());
	}

}

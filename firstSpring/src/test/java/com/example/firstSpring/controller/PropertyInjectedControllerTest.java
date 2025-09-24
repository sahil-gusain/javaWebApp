package com.example.firstSpring.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.firstSpring.service.GreetingIMPL;

class PropertyInjectedControllerTest {
     PropertyInjectedController cnt ;
     @BeforeEach
     void setup() {
    	 cnt = new PropertyInjectedController();
    	 cnt.greetingservice=new GreetingIMPL();
     }
	@Test
	void test() {
		System.out.println(cnt.sayHello());
	}

}

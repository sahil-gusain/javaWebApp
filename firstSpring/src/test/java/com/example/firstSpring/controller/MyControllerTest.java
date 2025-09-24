package com.example.firstSpring.controller;

import org.junit.jupiter.api.Test;

public class MyControllerTest {
   
	@Test
     void SayHello() {
		MyControllerForTest cnt = new MyControllerForTest();
		System.out.println(cnt.SayHello());
	}
	
}

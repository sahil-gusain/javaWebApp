package com.example.firstSpring.controller.i18n;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("Spanish")
public class Controller18nSpanish {
    @Autowired
	Myi18controller myi18controller;
     
     @Test
     void sayHello() {
    	 System.out.println(myi18controller.sayHello());
     }
}

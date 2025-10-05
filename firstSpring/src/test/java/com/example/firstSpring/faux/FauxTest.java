package com.example.firstSpring.faux;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.firstSpring.controller.faux.MyFauxController;

@SpringBootTest
@ActiveProfiles({"PROD","EN"})
public class FauxTest {
    @Autowired
	MyFauxController myFauxController;
    
    @Test
    void sayHello() {
    	System.out.println(myFauxController.sayHello());
    }
}

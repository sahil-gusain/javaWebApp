package com.example.firstSpring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.example.firstSpring.controller.MyController;

@SpringBootTest
class FirstSpringApplicationTests {

	@Autowired
	ApplicationContext cxt ;
	
	@Autowired
	MyController cont;
	
	
	@Test
	void testControllerwithDI()
	{
	   cont = cxt.getBean(MyController.class);
	   
	   System.out.println(cont.getMSG());
	}
	@Test
	void contextLoads() {
	}

}

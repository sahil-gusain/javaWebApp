package com.example.firstSpring.controller.faux;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.example.firstSpring.service.faux.EnvironmentService;

@Controller
public class MyFauxController {
	
    EnvironmentService environmentservice;
    
    public MyFauxController(@Qualifier("faux")EnvironmentService environmentService) {
    	this.environmentservice=environmentService;
    }
    
    public String sayHello() {
    	return environmentservice.getEnv();
    }
}

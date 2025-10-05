package com.example.firstSpring.service.faux;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("faux")
@Primary
@Profile("Dev")
public class EnvironmentDev implements EnvironmentService {

	@Override
	public String getEnv() {
		// TODO Auto-generated method stub
		return "Dev";
	}

}

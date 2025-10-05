package com.example.firstSpring.service.faux;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("faux")
@Profile("UAT")
public class EnvironmentUAT implements EnvironmentService {

	@Override
	public String getEnv() {
		// TODO Auto-generated method stub
		return "UAT";
	}

}

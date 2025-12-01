package com.sahil.lombok.controller;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sahil.lombok.model.Beer;
import com.sahil.lombok.model.Customer;
import com.sahil.lombok.service.CustomerService;
import com.sahil.lombok.service.CustomerServiceImpl;


@WebMvcTest(CustomerController.class)
class customerControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockitoBean
	CustomerService customerService;
	
	CustomerServiceImpl custImp = new CustomerServiceImpl();
	
	@Test
	void testListCustomer() throws Exception {
		given(customerService.custList()).willReturn(custImp.custList());
	 	
	 	mockMvc.perform(get("/api/v1/customers")
	 			.accept(MediaType.APPLICATION_JSON))
	 			.andExpectAll(status().isOk())
	 			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
	 			.andExpect(jsonPath("$.length()", is(3)));
	}
	 @Test
     void getCustomerById() throws Exception {
    	 Customer testCustomer = custImp.custList().get(0);
    	 
    	 given(customerService.getCustomerById(testCustomer.getCustId())).willReturn(testCustomer);
    	 
    	 
    	 mockMvc.perform(get("/api/v1/customers/" + testCustomer.getCustId())
    			 .accept(MediaType.APPLICATION_JSON)) 
    	 		 .andExpect(status().isOk())
    	 		 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    	 		.andExpect(jsonPath("$.custId", is(testCustomer.getCustId().toString())))
    	 		 .andExpect(jsonPath("$.custName", is(testCustomer.getCustName())));
   	 
     }

}

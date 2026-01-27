package com.sahil.lombok.controller;

import static org.mockito.ArgumentMatchers.any;

import java.util.UUID;

import org.hibernate.annotations.NotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.jackson.autoconfigure.JacksonAutoConfiguration;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sahil.lombok.model.CustomerDTO;
import com.sahil.lombok.service.CustomerService;
import com.sahil.lombok.service.CustomerServiceImpl;


@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc
@ImportAutoConfiguration(JacksonAutoConfiguration.class) 
class customerControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockitoBean
	CustomerService customerService;
	
	CustomerServiceImpl custImp ;
	
	@BeforeEach
	void setup() {
		 
		custImp = new CustomerServiceImpl();
	}
	
	
	@Test
	void deleteCustomerByIdtest() throws Exception {
		CustomerDTO cust  =custImp.custList().get(0);
		
		mockMvc.perform(delete(CustomerController.CUSTOMER_PATH_ID,cust.getCustId())
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
		
		ArgumentCaptor<UUID> uuidArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
		verify(customerService).deleteById(uuidArgumentCaptor.capture());
		
		assertThat(cust.getCustId()).isEqualTo(uuidArgumentCaptor.getValue());
		
		
	}
	
	  	@Test
	     void updateCustomerByIdTest () throws  Exception {
	    	  CustomerDTO cust = custImp.custList().get(0);
	    	   
	    	    mockMvc.perform(put(CustomerController.CUSTOMER_PATH_ID,cust.getCustId())
	    	    		.accept(MediaType.APPLICATION_JSON)
	            .contentType(MediaType.APPLICATION_JSON)
	            .content(objectMapper.writeValueAsString(cust)))
	            .andExpect(status().isNoContent());
	    	    
	    	    verify(customerService).updateCustomerById( any(UUID.class), any(CustomerDTO.class));
	    	    
	    	   
	    	    
	    	    //any does not care about the value just types
	    	    //verify is used to check if this method is called or not
	    	    
	     }
	
	@Test
	void createNewCustomerTest() {
		CustomerDTO customer = custImp.custList().get(0);
		
		customer.setCustId(null);
		customer.setVersion(null);
		

		given(customerService.createNewCustomer(any(CustomerDTO.class))).willReturn(customer);

		
	}
	
	@Test
	void testListCustomer() throws Exception {
		given(customerService.custList()).willReturn(custImp.custList());
	 	
	 	mockMvc.perform(get(CustomerController.CUSTOMER_PATH)
	 			.accept(MediaType.APPLICATION_JSON))
	 			.andExpectAll(status().isOk())
	 			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
	 			.andExpect(jsonPath("$.length()", is(3)));
	}
	
//	
	@Test
	void getCustomerByIdNotfound() throws Exception{
		given(customerService.getCustomerById(any(UUID.class))).willThrow(NotFoundException.class);
		
		mockMvc.perform(get(CustomerController.CUSTOMER_PATH_ID,UUID.randomUUID()))
						.andExpect(status().isNotFound());
	}
	 @Test
     void getCustomerById() throws Exception {
    	 CustomerDTO testCustomer = custImp.custList().get(0);
    	 
    	 given(customerService.getCustomerById(testCustomer.getCustId())).willReturn(testCustomer);
    	 
    	 
    	 mockMvc.perform(get(CustomerController.CUSTOMER_PATH_ID,testCustomer.getCustId())
    			 .accept(MediaType.APPLICATION_JSON)) 
    	 		 .andExpect(status().isOk())
    	 		 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    	 		.andExpect(jsonPath("$.custId", is(testCustomer.getCustId().toString())))
    	 		 .andExpect(jsonPath("$.custName", is(testCustomer.getCustName())));
   	 
     }

}

package com.sahil.lombok.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.lombok.model.Customer;
import com.sahil.lombok.service.CustomerService;

import lombok.AllArgsConstructor;
import java.util.List; 


@AllArgsConstructor
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
	private CustomerService customerservice;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> custList(){
		return customerservice.custList();
	}
	
	 @RequestMapping(value = "{customerId}",method = RequestMethod.GET)
	public Customer getBeerById(@PathVariable("customerId") UUID customerId) {
		return customerservice.getCustomerById(customerId);
	}

	
}

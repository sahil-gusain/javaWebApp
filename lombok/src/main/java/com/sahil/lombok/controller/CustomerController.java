package com.sahil.lombok.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.lombok.model.Customer;
import com.sahil.lombok.service.CustomerService;

import lombok.AllArgsConstructor;

import java.net.http.HttpHeaders;
import java.util.List; 


@AllArgsConstructor
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
	private CustomerService customerservice;
	
	@PostMapping
	public ResponseEntity<Void> createCustomer(@RequestBody   Customer newCust){
		Customer savedCustomer = customerservice.createNewCustomer(newCust);
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		
		headers.add("Location", "api/v1/customers/" + savedCustomer.getCustId());
		
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Customer> custList(){
		return customerservice.custList();
	}
	
	 @RequestMapping(value = "{customerId}",method = RequestMethod.GET)
	public Customer getBeerById(@PathVariable("customerId") UUID customerId) {
		return customerservice.getCustomerById(customerId);
	}

	
}

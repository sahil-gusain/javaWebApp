package com.sahil.lombok.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.lombok.model.BeerDTO;
import com.sahil.lombok.model.CustomerDTO;
import com.sahil.lombok.service.CustomerService;

import lombok.AllArgsConstructor;

import java.net.http.HttpHeaders;
import java.util.List; 


@AllArgsConstructor
@RestController
public class CustomerController {
	private CustomerService customerservice;
	
    public static final String CUSTOMER_PATH = "/api/v1/customers";
    public static final String CUSTOMER_PATH_ID = CUSTOMER_PATH + "/{customerId}";
	
	@PatchMapping(CUSTOMER_PATH_ID)
	public ResponseEntity<Void> updateBeerById(@PathVariable("customerId") UUID customerId,@RequestBody CustomerDTO customer){
		
		customerservice.updateCustomerPatchById(customerId, customer);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(CUSTOMER_PATH_ID)
	public ResponseEntity<Void> deleteById(@PathVariable("customerId")UUID customerId){
		
		customerservice.deleteById(customerId);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	@PutMapping(CUSTOMER_PATH_ID)
	public ResponseEntity<Void> updateById(@PathVariable("customerId")UUID customerId,@RequestBody CustomerDTO customer){
		
		customerservice.updateCustomerById(customerId,customer);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	@PostMapping(CUSTOMER_PATH)
	public ResponseEntity<Void> createCustomer(@RequestBody   CustomerDTO newCust){
		CustomerDTO savedCustomer = customerservice.createNewCustomer(newCust);
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		
		headers.add("Location", "api/v1/customers/" + savedCustomer.getCustId());
		
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
	
	 @RequestMapping(value=CUSTOMER_PATH,method = RequestMethod.GET)
	//@RequestMapping(method = RequestMethod.GET)
	public List<CustomerDTO> custList(){
		return customerservice.custList();
	}
	
	 @RequestMapping(value = CUSTOMER_PATH_ID,method = RequestMethod.GET)
	public CustomerDTO getBeerById(@PathVariable("customerId") UUID customerId) {
		return customerservice.getCustomerById(customerId);
	}

	
}

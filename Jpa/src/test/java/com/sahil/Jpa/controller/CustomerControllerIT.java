package com.sahil.Jpa.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


import com.sahil.Jpa.Repository.CustomerRepository;

import com.sahil.Jpa.entities.Customer;
import com.sahil.Jpa.model.CustomerDTO;
import jakarta.transaction.Transactional;


@SpringBootTest
class CustomerControllerIT {


	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerController customerController;

	@Test
	void testCustomerByIdNotNull() {
		assertThrows(NotFoundException.class, ()->{
			customerController.getCustomerById(UUID.randomUUID());
		});
	}
	
	@Test
	void testGetCustomerById() {
		
		Customer customer =customerRepository.findAll().get(0);
		System.out.println("Customer  : "  +customer.toString());
		 CustomerDTO dto = customerController.getCustomerById(customer.getId());
	
		 assertThat(dto).isNotNull();
	}
	@Test
	void testListCustomers() {
		List<CustomerDTO> bdto = customerController.listAllCustomers();
//		System.out.println(bdto.toString());
		assertThat(bdto.size()).isEqualTo(3);
	}
    @Rollback
    @Transactional
    @Test
    void testEmptyList() {
    	customerRepository.deleteAll();
        List<CustomerDTO> dtos = customerController.listAllCustomers();

        assertThat(dtos.size()).isEqualTo(0);
    }

}

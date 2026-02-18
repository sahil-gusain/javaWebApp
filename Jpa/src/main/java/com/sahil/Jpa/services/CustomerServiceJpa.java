package com.sahil.Jpa.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.sahil.Jpa.Mappers.CustomerMapper;
import com.sahil.Jpa.model.CustomerDTO;

import lombok.RequiredArgsConstructor;


@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJpa implements CustomerService {
	
	private final CustomerService customerService;
	private final CustomerMapper customerMapper;
	
	@Override
	public Optional<CustomerDTO> getCustomerById(UUID uuid) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO saveNewCustomer(CustomerDTO customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCustomerById(UUID customerId, CustomerDTO customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomerById(UUID customerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void patchCustomerById(UUID customerId, CustomerDTO customer) {
		// TODO Auto-generated method stub

	}

}

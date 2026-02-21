package com.sahil.Jpa.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.sahil.Jpa.Mappers.CustomerMapper;
import com.sahil.Jpa.Repository.CustomerRepository;
import com.sahil.Jpa.model.CustomerDTO;

import lombok.RequiredArgsConstructor;


@Service
@Primary
@RequiredArgsConstructor
public class CustomerServiceJpa implements CustomerService {
	
	private final CustomerRepository customerRepository;
	private final CustomerMapper customerMapper;
	
	@Override
	public Optional<CustomerDTO> getCustomerById(UUID id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(customerMapper.customerToCustomerDto(customerRepository.findById(id)
                .orElse(null))); 
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll()
				.stream()
				.map(customerMapper::customerToCustomerDto)
				.collect(Collectors.toList());
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

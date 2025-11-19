package com.sahil.lombok.service;

import java.util.List;
import java.util.UUID;

import com.sahil.lombok.model.Beer;
import com.sahil.lombok.model.Customer;

public interface CustomerService {
	List<Customer> custList();

    Customer getCustomerById(UUID beerid);

	Customer createNewCustomer(Customer newCust);


	void deleteById(UUID customerId);

	void updateCustomerPatchById(UUID customerId, Customer customer);

	void updateCustomerById(UUID customerId, Customer customer);
}

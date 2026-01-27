package com.sahil.lombok.service;

import java.util.List;
import java.util.UUID;

import com.sahil.lombok.model.BeerDTO;
import com.sahil.lombok.model.CustomerDTO;

public interface CustomerService {
	List<CustomerDTO> custList();

    CustomerDTO getCustomerById(UUID beerid);

	CustomerDTO createNewCustomer(CustomerDTO newCust);


	void deleteById(UUID customerId);

	void updateCustomerPatchById(UUID customerId, CustomerDTO customer);

	void updateCustomerById(UUID customerId, CustomerDTO customer);
}

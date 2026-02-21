package com.sahil.Jpa.Mappers;

import org.mapstruct.Mapper;

import com.sahil.Jpa.entities.Customer;
import com.sahil.Jpa.model.CustomerDTO;


@Mapper(componentModel = "spring")
public interface CustomerMapper {
	Customer customerDtoToCustomer(CustomerDTO customer);
	
	CustomerDTO customerToCustomerDto(Customer customer);
}

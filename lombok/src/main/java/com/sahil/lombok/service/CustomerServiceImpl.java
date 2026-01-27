package com.sahil.lombok.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sahil.lombok.model.BeerDTO;
import com.sahil.lombok.model.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService {
	private Map<UUID,CustomerDTO> customerMap;
	
	public CustomerServiceImpl() {
		this.customerMap =new HashMap<UUID, CustomerDTO>();
		
		CustomerDTO cust1= CustomerDTO.builder()
				.custName("Sahil")
				.custId(UUID.randomUUID())
				.version(1)
				.lastModifiedDate(LocalDateTime.now())
				.createdDate(LocalDateTime.now()).build();
		
		CustomerDTO cust2= CustomerDTO.builder()
				.custName("Harsh")
				.custId(UUID.randomUUID())
				.version(1)
				.lastModifiedDate(LocalDateTime.now())
				.createdDate(LocalDateTime.now()).build();
		
		CustomerDTO cust3= CustomerDTO.builder()
				.custName("Manish")
				.custId(UUID.randomUUID())
				.version(1)
				.lastModifiedDate(LocalDateTime.now())
				.createdDate(LocalDateTime.now()).build();
		
		customerMap.put(cust1.getCustId(), cust1);
		customerMap.put(cust2.getCustId(), cust2);
		customerMap.put(cust3.getCustId(), cust3);
	}

	@Override
		public List<CustomerDTO> custList() {
			// TODO Auto-generated method stub
			return new ArrayList<>(customerMap.values());
		}
	
	@Override
	public CustomerDTO getCustomerById(UUID customerId) {
		// TODO Auto-generated method stub
		return customerMap.get(customerId);
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO newCust) {
		// TODO Auto-generated method stub
		CustomerDTO tempCust = CustomerDTO.builder()
				.custName(newCust.getCustName()) 	
				.custId(UUID.randomUUID())
				.version(1)
				.lastModifiedDate(LocalDateTime.now())
				.createdDate(LocalDateTime.now()).build();
		
		customerMap.put(tempCust.getCustId(), tempCust);
		
		return tempCust;
	}

	@Override
	public void deleteById(UUID customerId) {
		// TODO Auto-generated method stub
		customerMap.remove(customerId);
	}

	@Override
	public void updateCustomerPatchById(UUID customerId, CustomerDTO customer) {
		// TODO Auto-generated method stub
		CustomerDTO existing = customerMap.get(customerId);
		
		if(customer.getCustName() != null) {
			existing.setCustName(customer.getCustName());
		}
		
  

	}

	@Override
	public void updateCustomerById(UUID customerId, CustomerDTO customer) {
		// TODO Auto-generated method stub
		CustomerDTO existing = customerMap.get(customerId);
		
		
		
		customerMap.put(customerId, existing);
		
	}

}

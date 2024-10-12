package com.wipro.capstone.customer.service;

import java.util.List;

import com.wipro.capstone.customer.dto.CustomerDTO;
import com.wipro.capstone.customer.entity.Customer;

public interface ICustomerService {

	public CustomerDTO createCustomer(CustomerDTO customerDTO);
	
    public CustomerDTO getCustomerById(Long id);
    
    public List<CustomerDTO> getAllCustomers();
    
    public Customer updateCustomer(CustomerDTO customerDTO);
    
    public String deleteCustomer(Long customerId);
}

package com.wipro.capstone.customer.service;

import java.util.List;

import com.wipro.capstone.customer.dto.CustomerDTO;

public interface ICustomerService {

	public CustomerDTO createCustomer(CustomerDTO customerDTO);
	
    public CustomerDTO getCustomerById(Long id);
    
    public List<CustomerDTO> getAllCustomers();
    
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    
    public void deleteCustomer(Long id);
}

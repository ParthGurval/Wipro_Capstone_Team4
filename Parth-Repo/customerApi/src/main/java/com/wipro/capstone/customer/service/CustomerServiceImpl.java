package com.wipro.capstone.customer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstone.customer.dto.CustomerDTO;
import com.wipro.capstone.customer.entity.Customer;
import com.wipro.capstone.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
    private CustomerRepository customerRepository;
	
	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getPassword()); // Assume password is already hashed
        customer.setSubscriptionType(customerDTO.getSubscriptionType());
        customer.setContactInfo(customerDTO.getContactInfo());
        customer.setAddress(customerDTO.getAddress());
        
        Customer savedCustomer = customerRepository.save(customer);
        customerDTO.setCustomerId(savedCustomer.getCustomerId());

        return customerDTO;
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {
		// TODO Auto-generated method stub
		 Customer customer = customerRepository.findById(id).orElse(null);
	        if (customer != null) {
	            return convertEntityToDTO(customer);
	        }
	        return null;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	@Override
	public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setName(customerDTO.getName());
            customer.setEmail(customerDTO.getEmail());
            customer.setPassword(customerDTO.getPassword());
            customer.setSubscriptionType(customerDTO.getSubscriptionType());
            customer.setContactInfo(customerDTO.getContactInfo());
            customer.setAddress(customerDTO.getAddress());
            
            Customer updatedCustomer = customerRepository.save(customer);
            return convertEntityToDTO(updatedCustomer);
        }
        return null;
	}

	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		 customerRepository.deleteById(id);
	}

	private CustomerDTO convertEntityToDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(customer.getCustomerId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPassword(customer.getPassword());
        dto.setSubscriptionType(customer.getSubscriptionType());
        dto.setContactInfo(customer.getContactInfo());
        dto.setAddress(customer.getAddress());
        return dto;
    }
}

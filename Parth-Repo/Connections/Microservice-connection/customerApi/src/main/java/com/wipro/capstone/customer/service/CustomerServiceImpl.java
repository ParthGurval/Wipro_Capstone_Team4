package com.wipro.capstone.customer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstone.customer.dto.CustomerDTO;
import com.wipro.capstone.customer.entity.Customer;
import com.wipro.capstone.customer.exception.ResourceNotFoundException;
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
//		 Customer customer = customerRepository.findById(id).orElse(null);
//	        if (customer != null) {
//	            return convertEntityToDTO(customer);
//	        }
//	        return null;
		
		Customer customer = customerRepository.findById(id).orElse(null);
		
		CustomerDTO custmoerDto = new CustomerDTO();
		
		custmoerDto.setCustomerId(customer.getCustomerId());
		custmoerDto.setName(customer.getName());
		custmoerDto.setEmail(customer.getEmail());
		custmoerDto.setPassword(customer.getPassword());
		custmoerDto.setSubscriptionType(customer.getSubscriptionType());
		custmoerDto.setContactInfo(customer.getContactInfo());
		custmoerDto.setAddress(customer.getAddress());
		
		return custmoerDto;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	@Override
	public Customer updateCustomer(CustomerDTO customerDTO) {
		// TODO Auto-generated method stub
//		Customer customer = customerRepository.findById(id).orElse(null);
//        if (customer != null) {
//            customer.setName(customerDTO.getName());
//            customer.setEmail(customerDTO.getEmail());
//            customer.setPassword(customerDTO.getPassword());
//            customer.setSubscriptionType(customerDTO.getSubscriptionType());
//            customer.setContactInfo(customerDTO.getContactInfo());
//            customer.setAddress(customerDTO.getAddress());
//            
//            Customer updatedCustomer = customerRepository.save(customer);
//            return convertEntityToDTO(updatedCustomer);
//        }
//        return null;
        
	    Long customerId = customerDTO.getCustomerId();
	    if (customerId == null) {
	        throw new IllegalArgumentException("Customer ID must not be null for update.");
	    }

	    // Fetch the existing FarmPartner
	    Customer existingCustomer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + customerId));

	    // Update the fields
	    existingCustomer.setName(customerDTO.getName());
	    existingCustomer.setEmail(customerDTO.getEmail());
	    existingCustomer.setPassword(customerDTO.getPassword());
	    existingCustomer.setSubscriptionType(customerDTO.getSubscriptionType());
	    existingCustomer.setContactInfo(customerDTO.getContactInfo());
	    existingCustomer.setAddress(customerDTO.getAddress());
	    // Save the updated entity
	    return customerRepository.save(existingCustomer);
	}

	@Override
	public String deleteCustomer(Long customerId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(customerId);

		return "Record Deleted For Customer ID: " + customerId;
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

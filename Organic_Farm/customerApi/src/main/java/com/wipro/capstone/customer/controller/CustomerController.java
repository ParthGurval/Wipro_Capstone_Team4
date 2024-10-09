package com.wipro.capstone.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.capstone.customer.dto.CustomerDTO;
import com.wipro.capstone.customer.service.ICustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping(value="/createCustomer")
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO) {
        // Save the customer through the service
        return customerService.createCustomer(customerDTO);
    }

    @GetMapping(value="getCustById/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        // Return the customer if found, or handle null appropriately
        return customerService.getCustomerById(id);
    }

    @GetMapping(value="/getAllCustomer")
    public List<CustomerDTO> getAllCustomers() {
        // Return list of all customers
        return customerService.getAllCustomers();
    }

    @PutMapping("updateCustomer/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
        // Update customer based on id
        return customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("deleteById/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        // Perform delete operation
        customerService.deleteCustomer(id);
        return "Customer with ID: " + id + " deleted successfully.";
    }
}

package com.wipro.capstone.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstone.customer.dto.Cart;
import com.wipro.capstone.customer.dto.CustomerDTO;
import com.wipro.capstone.customer.dto.OrderDTO;
import com.wipro.capstone.customer.dto.PaymentDTO;
import com.wipro.capstone.customer.dto.Product;
import com.wipro.capstone.customer.entity.Customer;
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

    @GetMapping(value="/getCustById/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        // Return the customer if found, or handle null appropriately
        return customerService.getCustomerById(id);
    }

    @GetMapping(value="/getAllCustomer")
    public List<CustomerDTO> getAllCustomers() {
        // Return list of all customers
        return customerService.getAllCustomers();
    }

//    @PutMapping("/updateCustomer/{id}")
//    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
//        // Update customer based on id
//        return customerService.updateCustomer(id, customerDTO);
//    }
    
    @PutMapping("/updateCustomer/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO) {
    	customerDTO.setCustomerId(id);  // Ensure the ID is set from the path variable
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("/deleteById/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        // Perform delete operation
    	return customerService.deleteCustomer(customerId);
    }
    
    
    // ON CustomerApi, Cartapi, ProductApi 
    /*
{

  "customerId": 1,
  "productId": 1,
  "quantity": 2,
  "price": 299.99
}
     */
    @PostMapping("/addProductToCart")
    public Cart addProductInCart(@RequestBody Cart cart) {
    	
    	return customerService.addProductToCart(cart);
    }
    
    @PutMapping("/updateCart/{cartId}")
    public Cart updateProductCart(@PathVariable Long cartId, @RequestBody Cart cart) {
    	
    	return customerService.updateCart(cartId, cart);
    }
    
    @GetMapping("/getCartId/{cartId}")
    public Cart getMyCartById(@PathVariable Long cartId) {
    	
    	return customerService.getCartById(cartId);
    }
    
    @DeleteMapping("/removeCart/{cartId}")
    public void removeProductFromCart(@PathVariable Long cartId) {
    	
    	customerService.removeProductFromCart(cartId);
    }
    
    @PostMapping("/createOrder")
    public OrderDTO createOrder(OrderDTO orderDto) {
    	
    	return customerService.createOrder(orderDto);
    }
    
    @PostMapping("/createPayment")
    public PaymentDTO createPayment(PaymentDTO paymentDTO) {
    	
    	return customerService.createPayment(paymentDTO);
    }
    
	@GetMapping("/getProductById/{productId}")
	public Product getProductById(@PathVariable Long productId) {
		
		return customerService.getProductById(productId);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProduct(){
		
		return customerService.getAllProduct();
	}
	
}

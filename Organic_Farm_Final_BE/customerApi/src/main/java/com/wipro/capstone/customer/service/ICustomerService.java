package com.wipro.capstone.customer.service;

import java.util.List;

import com.wipro.capstone.customer.dto.Cart;
import com.wipro.capstone.customer.dto.CustomerDTO;
import com.wipro.capstone.customer.dto.OrderDTO;
import com.wipro.capstone.customer.dto.PaymentDTO;
import com.wipro.capstone.customer.dto.Product;
import com.wipro.capstone.customer.entity.Customer;

public interface ICustomerService {

	public CustomerDTO createCustomer(CustomerDTO customerDTO);
	
    public CustomerDTO getCustomerById(Long id);
    
    public List<CustomerDTO> getAllCustomers();
    
    public Customer updateCustomer(CustomerDTO customerDTO);
    
    public String deleteCustomer(Long customerId);
    
    public Cart addProductToCart(Cart cart);
    
    public Cart updateCart(Long cartId, Cart cart);
    
    public Cart getCartById(Long cartId);
    
    public void removeProductFromCart(Long cartId);

    public OrderDTO createOrder(OrderDTO orderDto);
    
    public PaymentDTO createPayment(PaymentDTO paymentDTO);
    
    public Product getProductById(Long productId);
    
    public List<Product> getAllProduct();
}

package com.wipro.capstone.customer.service;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.capstone.customer.dto.Cart;
import com.wipro.capstone.customer.dto.CustomerDTO;
import com.wipro.capstone.customer.dto.OrderDTO;
import com.wipro.capstone.customer.dto.PaymentDTO;
import com.wipro.capstone.customer.dto.Product;
import com.wipro.capstone.customer.entity.Customer;
import com.wipro.capstone.customer.exception.ResourceNotFoundException;
import com.wipro.capstone.customer.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
    private CustomerRepository customerRepository;
	
    @Autowired
    private RestTemplate restTemplate;
    
    private final String CART_SERVICE_URL = "http://localhost:8083/api/carts";
    
    private final String ORDER_SERVICE_URL = "http://localhost:8085/api/orders";
    
    private final String PAYMENT_SERVICE_URL = "http://localhost:8082/api/payments";
	
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

	@Override
	public Cart addProductToCart(Cart cart) {
		// TODO Auto-generated method stub
//		return restTemplate.postForObject("http://localhost:8083/api/carts/addProduct", cart, Cart.class);
        String url = CART_SERVICE_URL + "/addProduct";
        return restTemplate.postForObject(url, cart, Cart.class);
	}

	@Override
	public Cart updateCart(Long cartId, Cart cart) {
		// TODO Auto-generated method stub
		
//		String url = CART_SERVICE_URL + "/updateCart/"  + cartId;
//		restTemplate.put(url, cart);
//		return getCartById(cartId);
		
        String url = CART_SERVICE_URL + "/updateCart/" + cartId;
        restTemplate.put(url, cart);
        return cart;
	}

	@Override
	public void removeProductFromCart(Long cartId) {
		// TODO Auto-generated method stub
		
//		restTemplate.delete("http://localhost:8083/api/carts/removeProduct/" + cartId, Cart.class);
//		
//		return "Record Deleted by Customer or Cart ID: " + cartId;
		
        String url = CART_SERVICE_URL + "/removeProduct/" + cartId;
        restTemplate.delete(url);
	}

	@Override
	public Cart getCartById(Long cartId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://localhost:8083/api/carts/getbyid/" + cartId, Cart.class);
	}

	@Override
	public OrderDTO createOrder(OrderDTO orderDto) {
		// TODO Auto-generated method stub
		String url = ORDER_SERVICE_URL + "/createOrder";
		return restTemplate.postForObject(url, orderDto, OrderDTO.class);
	}

	@Override
	public PaymentDTO createPayment(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		String url1 = PAYMENT_SERVICE_URL + "/createPayment";
		return restTemplate.postForObject(url1, paymentDTO, PaymentDTO.class);
	}

	@Override
	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://localhost:8989/api/products/getProductById/" + productId, Product.class);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		
		Product[] products = restTemplate.getForObject("http://localhost:8989/api/products/getAllProducts", Product[].class);
		return Arrays.asList(products);
	}
}

package com.wipro.capstone.cart.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.capstone.cart.dto.CartDTO;
import com.wipro.capstone.cart.dto.Product;
import com.wipro.capstone.cart.entity.Cart;
import com.wipro.capstone.cart.repository.CartRepository;

@Service
public class CartServiceImp implements ICartService {

    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Cart createCart(CartDTO cartDTO) {
        Cart cart = new Cart();
        
        cart.setCustomerId(cartDTO.getCustomerId());
        cart.setProductId(cartDTO.getProductId());
        cart.setQuantity(cartDTO.getQuantity());
        cart.setPrice(cartDTO.getPrice());

        
        return cartRepository.save(cart);
    }

    @Override
    public CartDTO getCartById(Long cart_id) {
        Cart cart = cartRepository.findById(cart_id).orElse(null);

        CartDTO cartDto = new CartDTO();
        cartDto.setCart_id(cart.getCart_id());
        cartDto.setCustomerId(cart.getCustomerId());
        cartDto.setProductId(cart.getProductId());
        cartDto.setQuantity(cart.getQuantity());
        cartDto.setPrice(cart.getPrice());
 

        return cartDto;
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart updateCart(CartDTO cartDTO) {
        Cart cart = new Cart();
        
        cart.setCart_id(cartDTO.getCart_id());
        cart.setCustomerId(cartDTO.getCustomerId());
        cart.setProductId(cartDTO.getProductId());
        cart.setQuantity(cartDTO.getQuantity());
        cart.setPrice(cartDTO.getPrice());

        return cartRepository.save(cart);
    }

    @Override
    public String deleteCart(Long cart_id) {
        cartRepository.deleteById(cart_id);
        return "Record Deleted For Cart ID: " + cart_id;
    }

    @Override
    public CartDTO addProductToCart(CartDTO cartDTO) {
        // Fetch product details from Product service
        Product product = restTemplate.getForObject("http://localhost:8989/api/products/getProductById/" + cartDTO.getProductId(), Product.class);

        // Set price from the product and create cart entity
        Cart cart = new Cart();
        cart.setCustomerId(cartDTO.getCustomerId());
        cart.setProductId(cartDTO.getProductId());
        cart.setQuantity(cartDTO.getQuantity());
        cart.setPrice(cartDTO.getPrice());

        Cart savedCart = cartRepository.save(cart);

        return mapToDTO(savedCart);
    }
    
    @Override
    public CartDTO updateCart(Long cartId, CartDTO cartDTO) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));

        cart.setQuantity(cartDTO.getQuantity());
        cart.setUpdatedAt(LocalDateTime.now());
        
        Cart updatedCart = cartRepository.save(cart);
        return mapToDTO(updatedCart);
    }

    @Override
    public void removeProductFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    @Override
    public List<CartDTO> getAllCartItemsByCustomerId(Long customerId) {
        List<Cart> carts = cartRepository.findByCustomerId(customerId);
        return carts.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
	
    private CartDTO mapToDTO(Cart cart) {
        return new CartDTO(cart.getCart_id(), cart.getCustomerId(), cart.getProductId(), cart.getQuantity(), cart.getPrice());
    }
}

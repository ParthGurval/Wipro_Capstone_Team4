package com.wipro.capstone.cart.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.capstone.cart.dto.CartDTO;
import com.wipro.capstone.cart.entity.Cart;
import com.wipro.capstone.cart.repository.CartRepository;

@Service
public class CartServiceImp implements ICartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart createCart(CartDTO cartDTO) {
        Cart cart = new Cart();
        
        cart.setCustomer_id(cartDTO.getCustomer_id());
        cart.setProduct_id(cartDTO.getProduct_id());
        cart.setQuantity(cartDTO.getQuantity());

        return cartRepository.save(cart);
    }

    @Override
    public CartDTO getCartById(Long cart_id) {
        Cart cart = cartRepository.findById(cart_id).orElse(null);

        CartDTO cartDto = new CartDTO();
        cartDto.setCart_id(cart.getCart_id());
        cartDto.setCustomer_id(cart.getCustomer_id());
        cartDto.setProduct_id(cart.getProduct_id());
        cartDto.setQuantity(cart.getQuantity());

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
        cart.setCustomer_id(cartDTO.getCustomer_id());
        cart.setProduct_id(cartDTO.getProduct_id());
        cart.setQuantity(cartDTO.getQuantity());

        return cartRepository.save(cart);
    }

    @Override
    public String deleteCart(Long cart_id) {
        cartRepository.deleteById(cart_id);
        return "Record Deleted For Cart ID: " + cart_id;
    }
}

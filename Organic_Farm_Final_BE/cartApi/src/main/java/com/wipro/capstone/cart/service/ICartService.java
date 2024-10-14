package com.wipro.capstone.cart.service;



import java.util.List;
import com.wipro.capstone.cart.dto.CartDTO;
import com.wipro.capstone.cart.entity.Cart;

public interface ICartService {

    public Cart createCart(CartDTO cartDTO);
    
    public CartDTO getCartById(Long cart_id);
    
    public List<Cart> getAllCarts();
    
    public Cart updateCart(CartDTO cartDTO);
    
    public String deleteCart(Long cart_id);
    
    CartDTO addProductToCart(CartDTO cartDTO);
    
    CartDTO updateCart(Long cartId, CartDTO cartDTO);
    
    void removeProductFromCart(Long cartId);
    
    List<CartDTO> getAllCartItemsByCustomerId(Long customerId);
}

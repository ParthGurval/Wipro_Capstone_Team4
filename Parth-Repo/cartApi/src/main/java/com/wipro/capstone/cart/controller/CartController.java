package com.wipro.capstone.cart.controller;

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
import com.wipro.capstone.cart.dto.CartDTO;
import com.wipro.capstone.cart.entity.Cart;
import com.wipro.capstone.cart.service.CartServiceImp;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartServiceImp cartService;
    
    @PostMapping(value="/createCart")
    public Cart createCart(@RequestBody CartDTO cartDTO) {
        return cartService.createCart(cartDTO);
    }
    
    @GetMapping(value="/getbyid/{cart_id}")
    public CartDTO getCartById(@PathVariable Long cart_id) {
        return cartService.getCartById(cart_id);
    }
    
    @GetMapping("/getallCarts")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }
    
    @PutMapping("/updateCart")
    public Cart updateCart(@RequestBody CartDTO cartDTO) {
        return cartService.updateCart(cartDTO);
    }
    
    @DeleteMapping("/deletebyid/{cart_id}")
    public String deleteCartById(@PathVariable Long cart_id) {
        return cartService.deleteCart(cart_id);
    }
    

    @PostMapping("/addProduct")
    public CartDTO addProductToCart(@RequestBody CartDTO cartDTO) {
        return cartService.addProductToCart(cartDTO);
    }

    @PutMapping("/updateCart/{cartId}")
    public CartDTO updateCart(@PathVariable Long cartId, @RequestBody CartDTO cartDTO) {
        return cartService.updateCart(cartId, cartDTO);
    }

    @DeleteMapping("/removeProduct/{cartId}")
    public void removeProductFromCart(@PathVariable Long cartId) {
        cartService.removeProductFromCart(cartId);
    }
    
    @GetMapping("/customer/{customerId}")
    public List<CartDTO> getAllCartItemsByCustomerId(@PathVariable Long customerId) {
        return cartService.getAllCartItemsByCustomerId(customerId);
    }
}


package com.wipro.capstone.cart.service;

import com.wipro.capstone.cart.dto.CartDTO;
import com.wipro.capstone.cart.entity.Cart;
import com.wipro.capstone.cart.repository.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CartServiceImpTest {

    @InjectMocks
    private CartServiceImp cartServiceImp;

    @Mock
    private CartRepository cartRepository;

    private CartDTO cartDTO;
    private Cart cart;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cartDTO = new CartDTO(1L, 1L, 1L, 2, 100.0);
        cart = new Cart();
        cart.setCart_id(1L);
        cart.setCustomerId(1L);
        cart.setProductId(1L);
        cart.setQuantity(2);
        cart.setPrice(100.0);
    }

    @Test
    void createCart_ShouldSaveCart() {
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        Cart createdCart = cartServiceImp.createCart(cartDTO);

        assertNotNull(createdCart);
        assertEquals(cartDTO.getCustomerId(), createdCart.getCustomerId());
        verify(cartRepository, times(1)).save(any(Cart.class));
    }

    @Test
    void getCartById_ShouldReturnCartDTO() {
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));

        CartDTO result = cartServiceImp.getCartById(1L);

        assertNotNull(result);
        assertEquals(cart.getCart_id(), result.getCart_id());
        assertEquals(cart.getCustomerId(), result.getCustomerId());
    }

    @Test
    void getAllCarts_ShouldReturnListOfCarts() {
        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart);
        when(cartRepository.findAll()).thenReturn(cartList);

        List<Cart> result = cartServiceImp.getAllCarts();

        assertEquals(1, result.size());
        assertEquals(cart.getCart_id(), result.get(0).getCart_id());
    }

    @Test
    void updateCart_ShouldUpdateExistingCart() {
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        Cart updatedCart = cartServiceImp.updateCart(cartDTO);

        assertNotNull(updatedCart);
        assertEquals(cartDTO.getQuantity(), updatedCart.getQuantity());
        verify(cartRepository, times(1)).save(any(Cart.class));
    }

    @Test
    void deleteCart_ShouldDeleteExistingCart() {
        doNothing().when(cartRepository).deleteById(1L);

        String result = cartServiceImp.deleteCart(1L);

        assertEquals("Record Deleted For Cart ID: 1", result);
        verify(cartRepository, times(1)).deleteById(1L);
    }

    @Test
    void addProductToCart_ShouldAddProductAndReturnCartDTO() {
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);
        // Assuming you have a mock for RestTemplate as well for the product retrieval

        CartDTO result = cartServiceImp.addProductToCart(cartDTO);

        assertNotNull(result);
        assertEquals(cartDTO.getCustomerId(), result.getCustomerId());
        verify(cartRepository, times(1)).save(any(Cart.class));
    }

    @Test
    void updateCartWithValidId_ShouldUpdateAndReturnCartDTO() {
        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        CartDTO result = cartServiceImp.updateCart(1L, cartDTO);

        assertNotNull(result);
        assertEquals(cartDTO.getQuantity(), result.getQuantity());
    }

    @Test
    void removeProductFromCart_ShouldDeleteCartById() {
        doNothing().when(cartRepository).deleteById(1L);

        cartServiceImp.removeProductFromCart(1L);

        verify(cartRepository, times(1)).deleteById(1L);
    }

    @Test
    void getAllCartItemsByCustomerId_ShouldReturnListOfCartDTOs() {
        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart);
        when(cartRepository.findByCustomerId(1L)).thenReturn(cartList);

        List<CartDTO> result = cartServiceImp.getAllCartItemsByCustomerId(1L);

        assertEquals(1, result.size());
        assertEquals(cart.getCart_id(), result.get(0).getCart_id());
    }
}

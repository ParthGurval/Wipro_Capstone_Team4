package com.wipro.capstone.order.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.wipro.capstone.order.dto.OrderDTO;
import com.wipro.capstone.order.entity.Order;
import com.wipro.capstone.order.entity.OrderStatus;
import com.wipro.capstone.order.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImpTest {

    @InjectMocks
    private OrderServiceImp orderService;

    @Mock
    private OrderRepository orderRepository;

    private OrderDTO orderDTO;
    private Order order;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderDTO = new OrderDTO(1L, 100L, 200L, LocalDate.parse("2024-10-15"), 150.0, OrderStatus.PENDING);
        order = new Order();
        order.setOrder_id(1L);
        order.setCustomerId(100L);
        order.setPartnerId(200L);
        order.setOrder_date(LocalDate.parse("2024-10-15"));
        order.setTotal_amount(150.0);
        order.setStatus(OrderStatus.PENDING);
    }

    @AfterEach
    public void tearDown() {
        // Code to reset or clean up after each test
        orderDTO = null;
        order = null;
    }

    @AfterAll
    public static void cleanUpAfterAll() {
        // Code to run once after all tests have been executed (if needed)
        System.out.println("All tests completed.");
    }

    @Test
    public void testCreateOrder() {
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        Order createdOrder = orderService.createOrder(orderDTO);
        assertNotNull(createdOrder);
        assertEquals(orderDTO.getOrder_id(), createdOrder.getOrder_id());
    }

    @Test
    public void testGetOrderById_ExistingId() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        OrderDTO foundOrder = orderService.getOrderById(1L);
        assertNotNull(foundOrder);
        assertEquals(orderDTO.getOrder_id(), foundOrder.getOrder_id());
    }

    @Test
    public void testGetOrderById_NonExistingId() {
        when(orderRepository.findById(2L)).thenReturn(Optional.empty());
        OrderDTO foundOrder = orderService.getOrderById(2L);
        assertNull(foundOrder);
    }

    @Test
    public void testGetAllOrders() {
        when(orderRepository.findAll()).thenReturn(Arrays.asList(order));
        List<Order> orders = orderService.getAllOrders();
        assertEquals(1, orders.size());
    }

    @Test
    public void testUpdateOrder_ExistingId() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        Order updatedOrder = orderService.updateOrder(orderDTO);
        assertNotNull(updatedOrder);
        assertEquals(orderDTO.getOrder_id(), updatedOrder.getOrder_id());
    }

    @Test
    public void testUpdateOrder_NonExistingId() {
        when(orderRepository.findById(2L)).thenReturn(Optional.empty());
        Order updatedOrder = orderService.updateOrder(orderDTO);
        assertNull(updatedOrder);
    }

    @Test
    public void testUpdateOrderStatus_ExistingId() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        Order updatedOrder = orderService.updateOrderStatus(1L, OrderStatus.COMPLETED);
        assertNotNull(updatedOrder);
        assertEquals(OrderStatus.COMPLETED, updatedOrder.getStatus());
    }

    @Test
    public void testUpdateOrderStatus_NonExistingId() {
        when(orderRepository.findById(2L)).thenReturn(Optional.empty());
        Order updatedOrder = orderService.updateOrderStatus(2L, OrderStatus.COMPLETED);
        assertNull(updatedOrder);
    }

    @Test
    public void testDeleteOrder_ExistingId() {
        doNothing().when(orderRepository).deleteById(1L);
        String result = orderService.deleteOrder(1L);
        assertEquals("Record Deleted For Order ID: 1", result);
    }

    @Test
    public void testDeleteOrder_NonExistingId() {
        doThrow(new RuntimeException()).when(orderRepository).deleteById(2L);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            orderService.deleteOrder(2L);
        });
        assertNotNull(exception);
    }

    @Test
    public void testGetOrdersByCustomerId_ExistingCustomer() {
        when(orderRepository.findByCustomerId(100L)).thenReturn(Arrays.asList(order));
        List<OrderDTO> orders = orderService.getOrdersByCustomerId(100L);
        assertEquals(1, orders.size());
    }

    @Test
    public void testGetOrdersByCustomerId_NonExistingCustomer() {
        when(orderRepository.findByCustomerId(999L)).thenReturn(Arrays.asList());
        List<OrderDTO> orders = orderService.getOrdersByCustomerId(999L);
        assertTrue(orders.isEmpty());
    }
}

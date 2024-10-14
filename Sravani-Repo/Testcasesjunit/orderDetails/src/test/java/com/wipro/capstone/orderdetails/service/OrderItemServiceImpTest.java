package com.wipro.capstone.orderdetails.service;

import com.wipro.capstone.orderdetails.dto.OrderItemDTO;
import com.wipro.capstone.orderdetails.entity.OrderItem;
import com.wipro.capstone.orderdetails.repository.OrderItemRepository;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OrderItemServiceImpTest {

    @InjectMocks
    private OrderItemServiceImp orderItemService;

    @Mock
    private OrderItemRepository orderItemRepository;

    private OrderItemDTO orderItemDTO;
    private OrderItem orderItem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderItemDTO = new OrderItemDTO(1L, 1L, 1L, 2, 100.0);
        orderItem = new OrderItem();
        orderItem.setOrder_item_id(1L);
        orderItem.setOrder_id(1L);
        orderItem.setProduct_id(1L);
        orderItem.setQuantity(2);
        orderItem.setPrice(100.0);
    }

    @AfterEach
    public void tearDown() {
        // Cleanup after each test, if necessary
        orderItemDTO = null;
        orderItem = null;
        System.out.println("Tear down executed after each test.");
    }

    @AfterAll
    public static void afterAllTests() {
        // Code that runs after all tests have executed, e.g., closing resources
        System.out.println("All tests completed.");
    }

    // Test case for creating an order item
    @Test
    void createOrderItem_ShouldSaveOrderItem() {
        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(orderItem);

        OrderItem createdOrderItem = orderItemService.createOrderItem(orderItemDTO);

        assertNotNull(createdOrderItem);
        assertEquals(orderItemDTO.getOrder_id(), createdOrderItem.getOrder_id());
        verify(orderItemRepository, times(1)).save(any(OrderItem.class));
    }

    // Test case for retrieving an order item by ID
    @Test
    void getOrderItemById_ShouldReturnOrderItemDTO() {
        when(orderItemRepository.findById(1L)).thenReturn(Optional.of(orderItem));

        OrderItemDTO result = orderItemService.getOrderItemById(1L);

        assertNotNull(result);
        assertEquals(orderItem.getOrder_item_id(), result.getOrder_item_id());
        assertEquals(orderItem.getOrder_id(), result.getOrder_id());
    }

    // Test case for retrieving all order items
    @Test
    void getAllOrderItems_ShouldReturnListOfOrderItems() {
        when(orderItemRepository.findAll()).thenReturn(Arrays.asList(orderItem));

        List<OrderItem> result = orderItemService.getAllOrderItems();

        assertEquals(1, result.size());
        assertEquals(orderItem.getOrder_item_id(), result.get(0).getOrder_item_id());
    }

    // Test case for updating an order item
    @Test
    void updateOrderItem_ShouldUpdateExistingOrderItem() {
        when(orderItemRepository.findById(1L)).thenReturn(Optional.of(orderItem));
        when(orderItemRepository.save(any(OrderItem.class))).thenReturn(orderItem);

        OrderItem updatedOrderItem = orderItemService.updateOrderItem(orderItemDTO);

        assertNotNull(updatedOrderItem);
        assertEquals(orderItemDTO.getQuantity(), updatedOrderItem.getQuantity());
        verify(orderItemRepository, times(1)).save(any(OrderItem.class));
    }

    // Test case for deleting an order item
    @Test
    void deleteOrderItem_ShouldDeleteExistingOrderItem() {
        doNothing().when(orderItemRepository).deleteById(1L);

        String result = orderItemService.deleteOrderItem(1L);

        assertEquals("Record Deleted For OrderItem ID: 1", result);
        verify(orderItemRepository, times(1)).deleteById(1L);
    }
}

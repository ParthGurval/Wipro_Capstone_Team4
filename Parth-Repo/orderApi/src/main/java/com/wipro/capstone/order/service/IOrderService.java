package com.wipro.capstone.order.service;


import java.util.List;

import com.wipro.capstone.order.dto.CustomerOrderVO;
import com.wipro.capstone.order.dto.FarmPartnerOrderVO;
import com.wipro.capstone.order.dto.OrderDTO;
import com.wipro.capstone.order.entity.Order;
import com.wipro.capstone.order.entity.OrderStatus; // Add this import for OrderStatus enum
  

public interface IOrderService {

    // Create a new order
    public Order createOrder(OrderDTO orderDTO);
    
    // Get an order by its ID
    public OrderDTO getOrderById(Long order_id);
    
    // Get a list of all orders
    public List<Order> getAllOrders();
    
    // Update an existing order
    public Order updateOrder(OrderDTO orderDTO);
    
    // Update the status of an order
    public Order updateOrderStatus(Long order_id, OrderStatus status);
    
    // Delete an order by its ID
    public String deleteOrder(Long order_id);
    
    public List<OrderDTO> getOrdersByCustomerId(Long customerId);
    
    public List<OrderDTO> getOrderByFarmPartnerId(Long partnerId);
    
    public CustomerOrderVO getCustomerByOrder(Long order_id);
    
    public FarmPartnerOrderVO getFarmPartnerByOrder(Long order_id);
    
}

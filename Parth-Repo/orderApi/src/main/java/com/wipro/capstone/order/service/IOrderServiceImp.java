package com.wipro.capstone.order.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.capstone.order.dto.OrderDTO;
import com.wipro.capstone.order.entity.Order;
import com.wipro.capstone.order.entity.OrderStatus;
import com.wipro.capstone.order.repository.OrderRepository;

@Service
public class IOrderServiceImp implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomer_id(orderDTO.getCustomer_id());
        order.setOrder_date(orderDTO.getOrder_date());
        order.setTotal_amount(orderDTO.getTotal_amount());
        order.setStatus(OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    @Override
    public OrderDTO getOrderById(Long order_id) {
        Order order = orderRepository.findById(order_id).orElse(null);

        if (order == null) {
            return null;
        }

        OrderDTO orderDto = new OrderDTO();
        orderDto.setOrder_id(order.getOrder_id());
        orderDto.setCustomer_id(order.getCustomer_id());
        orderDto.setOrder_date(order.getOrder_date());
        orderDto.setTotal_amount(order.getTotal_amount());
        orderDto.setStatus(order.getStatus());

        return orderDto;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(OrderDTO orderDTO) {
        Order order = orderRepository.findById(orderDTO.getOrder_id()).orElse(null);

        if (order != null) {
            order.setCustomer_id(orderDTO.getCustomer_id());
            order.setOrder_date(orderDTO.getOrder_date());
            order.setTotal_amount(orderDTO.getTotal_amount());
            order.setStatus(orderDTO.getStatus());
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public Order updateOrderStatus(Long order_id, OrderStatus status) {
        Order order = orderRepository.findById(order_id).orElse(null);

        if (order != null) {
            order.setStatus(status);
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public String deleteOrder(Long order_id) {
        orderRepository.deleteById(order_id);
        return "Record Deleted For Order ID: " + order_id;
    }
}

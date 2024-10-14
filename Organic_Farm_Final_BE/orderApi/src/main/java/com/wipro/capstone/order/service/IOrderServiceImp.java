package com.wipro.capstone.order.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.capstone.order.dto.Customer;
import com.wipro.capstone.order.dto.CustomerOrderVO;
import com.wipro.capstone.order.dto.FarmPartner;
import com.wipro.capstone.order.dto.FarmPartnerOrderVO;
import com.wipro.capstone.order.dto.OrderDTO;
import com.wipro.capstone.order.entity.Order;
import com.wipro.capstone.order.entity.OrderStatus;
import com.wipro.capstone.order.repository.OrderRepository;

@Service
public class IOrderServiceImp implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setCustomerId(orderDTO.getCustomerId());
        order.setPartnerId(orderDTO.getPartnerId());
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
        orderDto.setCustomerId(order.getCustomerId());
        orderDto.setPartnerId(order.getPartnerId());
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
            order.setCustomerId(orderDTO.getCustomerId());
            order.setPartnerId(orderDTO.getPartnerId());
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

    @Override
    public List<OrderDTO> getOrdersByCustomerId(Long customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    
	@Override
	public List<OrderDTO> getOrderByFarmPartnerId(Long partnerId) {
		// TODO Auto-generated method stub
		List<Order> orders = orderRepository.findByPartnerId(partnerId);
		return orders.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public CustomerOrderVO getCustomerByOrder(Long order_id) {
		// TODO Auto-generated method stub
		OrderDTO orderDto = getOrderById(order_id);
		
		Long customerId = orderDto.getCustomerId();
		
		Customer customer = restTemplate.getForObject("http://localhost:8787/api/customers/getCustById/" + customerId, Customer.class);
		
		CustomerOrderVO CustOrderVO = new CustomerOrderVO();
		
		CustOrderVO.setOrder(orderDto);
		CustOrderVO.setCustomer(customer);
		
		return CustOrderVO;
	}

	@Override
	public FarmPartnerOrderVO getFarmPartnerByOrder(Long order_id) {
		// TODO Auto-generated method stub
		OrderDTO orderDto = getOrderById(order_id);
		
		Long partnerId = orderDto.getPartnerId();
		
		FarmPartner farmPartner = restTemplate.getForObject("http://localhost:8484/api/farmpartners/getbyid/" + partnerId, FarmPartner.class);
		
		FarmPartnerOrderVO partnerOrderVO = new FarmPartnerOrderVO();
		
		partnerOrderVO.setOrderDto(orderDto);
		partnerOrderVO.setFarmPartner(farmPartner);
		
		return partnerOrderVO;
	}


	
    private OrderDTO convertToDTO(Order order) {
        return new OrderDTO(
                order.getOrder_id(),
                order.getCustomerId(),
                order.getPartnerId(),
                order.getOrder_date(),
                order.getTotal_amount(),
                order.getStatus()
                
        );
    }

}

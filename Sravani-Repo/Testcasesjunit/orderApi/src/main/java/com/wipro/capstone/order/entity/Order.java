package com.wipro.capstone.order.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id; // Primary key

    private Long customerId; // Foreign key (relationship to customer)
    
    private Long partnerId;

    private LocalDate order_date; // Order date

    private Double total_amount; // Total amount for the order

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // Enum for order status

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Long order_id, Long customerId, Long partnerId, LocalDate order_date, Double total_amount,
			OrderStatus status) {
		super();
		this.order_id = order_id;
		this.customerId = customerId;
		this.partnerId = partnerId;
		this.order_date = order_date;
		this.total_amount = total_amount;
		this.status = status;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(Long partnerId) {
		this.partnerId = partnerId;
	}

	public LocalDate getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customerId=" + customerId + ", partnerId=" + partnerId
				+ ", order_date=" + order_date + ", total_amount=" + total_amount + ", status=" + status + "]";
	}

	
    
}

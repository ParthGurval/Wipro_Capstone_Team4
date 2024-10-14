package com.wipro.capstone.cart.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;

    private Long customerId;
    
    @ElementCollection
    private List<Long> productId;

    private Integer quantity;

    private Double price;
    
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Long cart_id, Long customerId, List<Long> productId, Integer quantity, Double price,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.cart_id = cart_id;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getCart_id() {
		return cart_id;
	}

	public void setCart_id(Long cart_id) {
		this.cart_id = cart_id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<Long> getProductId() {
		return productId;
	}

	public void setProductId(List<Long> productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Cart [cart_id=" + cart_id + ", customerId=" + customerId + ", productId=" + productId + ", quantity="
				+ quantity + ", price=" + price + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}

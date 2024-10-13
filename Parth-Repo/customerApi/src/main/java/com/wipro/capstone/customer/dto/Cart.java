package com.wipro.capstone.customer.dto;



public class Cart {

    private Long cart_id;
    private Long customerId;
    private Long productId;
    private Integer quantity;
    private Double price;
    
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(Long cart_id, Long customerId, Long productId, Integer quantity, Double price) {
		super();
		this.cart_id = cart_id;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
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

	@Override
	public String toString() {
		return "CartDTO [cart_id=" + cart_id + ", customerId=" + customerId + ", productId=" + productId + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
    
	

    
}


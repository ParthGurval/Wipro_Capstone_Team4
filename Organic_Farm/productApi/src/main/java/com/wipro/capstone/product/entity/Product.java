package com.wipro.capstone.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    @Enumerated(EnumType.STRING)
    private ProductType type;

    private Double price;

    private Integer availableQuantity;

    @Column(name = "farm_partner_id")
    private Long farmPartnerId;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long productId, String name, ProductType type, Double price, Integer availableQuantity,
			Long farmPartnerId) {
		super();
		this.productId = productId;
		this.name = name;
		this.type = type;
		this.price = price;
		this.availableQuantity = availableQuantity;
		this.farmPartnerId = farmPartnerId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Long getFarmPartnerId() {
		return farmPartnerId;
	}

	public void setFarmPartnerId(Long farmPartnerId) {
		this.farmPartnerId = farmPartnerId;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", availableQuantity="
				+ availableQuantity + ", farmPartnerId=" + farmPartnerId + "]";
	}
    
    
}

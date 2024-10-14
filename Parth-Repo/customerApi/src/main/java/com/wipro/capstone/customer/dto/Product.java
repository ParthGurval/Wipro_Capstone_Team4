package com.wipro.capstone.customer.dto;

public class Product {

	 	private Long productId;
	    private String name;
	    private String type; // You can use ProductType enum here if you prefer.
	    private Double price;
	    private Integer availableQuantity;
	    private Long partnerId;
		
	    public Product() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Product(Long productId, String name, String type, Double price, Integer availableQuantity,
				Long partnerId) {
			super();
			this.productId = productId;
			this.name = name;
			this.type = type;
			this.price = price;
			this.availableQuantity = availableQuantity;
			this.partnerId = partnerId;
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

		public String getType() {
			return type;
		}

		public void setType(String type) {
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

		public Long getPartnerId() {
			return partnerId;
		}

		public void setPartnerId(Long partnerId) {
			this.partnerId = partnerId;
		}

		@Override
		public String toString() {
			return "ProductDTO [productId=" + productId + ", name=" + name + ", type=" + type + ", price=" + price
					+ ", availableQuantity=" + availableQuantity + ", partnerId=" + partnerId + "]";
		}
	      
	    
}

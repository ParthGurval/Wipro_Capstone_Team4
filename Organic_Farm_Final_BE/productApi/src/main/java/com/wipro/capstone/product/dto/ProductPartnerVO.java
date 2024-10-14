package com.wipro.capstone.product.dto;

public class ProductPartnerVO {

	private ProductDTO productDto;
	
	private FarmPartner farmPartner;

	public ProductPartnerVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductPartnerVO(ProductDTO productDto, FarmPartner farmPartner) {
		super();
		this.productDto = productDto;
		this.farmPartner = farmPartner;
	}

	public ProductDTO getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDTO productDto) {
		this.productDto = productDto;
	}

	public FarmPartner getFarmPartner() {
		return farmPartner;
	}

	public void setFarmPartner(FarmPartner farmPartner) {
		this.farmPartner = farmPartner;
	}

	@Override
	public String toString() {
		return "ProductPartnerVO [productDto=" + productDto + ", farmPartner=" + farmPartner + "]";
	}
	
	
	
}

package com.wipro.capstone.order.dto;

public class FarmPartnerOrderVO {
	
	FarmPartner farmPartner;
	
	OrderDTO orderDto;

	public FarmPartnerOrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FarmPartnerOrderVO(FarmPartner farmPartner, OrderDTO orderDto) {
		super();
		this.farmPartner = farmPartner;
		this.orderDto = orderDto;
	}

	public FarmPartner getFarmPartner() {
		return farmPartner;
	}

	public void setFarmPartner(FarmPartner farmPartner) {
		this.farmPartner = farmPartner;
	}

	public OrderDTO getOrderDto() {
		return orderDto;
	}

	public void setOrderDto(OrderDTO orderDto) {
		this.orderDto = orderDto;
	}

	@Override
	public String toString() {
		return "FarmPartnerOrderVO [farmPartner=" + farmPartner + ", orderDto=" + orderDto + "]";
	}
	
	

}

package com.wipro.capstone.admin.dto;

public class AdminCustomerVO {

	private AdminDTO admindto;
	
	private Customer customer;

	public AdminCustomerVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminCustomerVO(AdminDTO admindto, Customer customer) {
		super();
		this.admindto = admindto;
		this.customer = customer;
	}

	public AdminDTO getAdmindto() {
		return admindto;
	}

	public void setAdmindto(AdminDTO admindto) {
		this.admindto = admindto;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "AdminCustomerVO [admindto=" + admindto + ", customer=" + customer + "]";
	}
	
	
	
}

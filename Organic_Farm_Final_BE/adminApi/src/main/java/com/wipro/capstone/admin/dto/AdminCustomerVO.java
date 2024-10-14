package com.wipro.capstone.admin.dto;

public class AdminCustomerVO {

	private AdminDTO admin;
	
	private Customer customer;

	public AdminCustomerVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminCustomerVO(AdminDTO admin, Customer customer) {
		super();
		this.admin = admin;
		this.customer = customer;
	}

	public AdminDTO getAdmin() {
		return admin;
	}

	public void setAdmin(AdminDTO admin) {
		this.admin = admin;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "AdminCustomerVO [admin=" + admin + ", customer=" + customer + "]";
	}
	
	

	
	
	
	
}

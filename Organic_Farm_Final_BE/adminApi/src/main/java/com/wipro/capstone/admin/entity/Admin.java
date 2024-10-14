package com.wipro.capstone.admin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long adminId;
	    
	    private String username;
	    private String email;
	    private String password;
	    private String role;
	    private String contactInfo;
	    private String address;
	    private String customerId;
	    
	    
		public Admin() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Admin(Long adminId, String username, String email, String password, String role, String contactInfo,
				String address, String customerId) {
			super();
			this.adminId = adminId;
			this.username = username;
			this.email = email;
			this.password = password;
			this.role = role;
			this.contactInfo = contactInfo;
			this.address = address;
			this.customerId = customerId;
		}


		public Long getAdminId() {
			return adminId;
		}


		public void setAdminId(Long adminId) {
			this.adminId = adminId;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getRole() {
			return role;
		}


		public void setRole(String role) {
			this.role = role;
		}


		public String getContactInfo() {
			return contactInfo;
		}


		public void setContactInfo(String contactInfo) {
			this.contactInfo = contactInfo;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public String getCustomerId() {
			return customerId;
		}


		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}


		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", username=" + username + ", email=" + email + ", password="
					+ password + ", role=" + role + ", contactInfo=" + contactInfo + ", address=" + address
					+ ", customerId=" + customerId + "]";
		}
	    
		
	    
	
}

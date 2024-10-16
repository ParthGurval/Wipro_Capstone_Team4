package com.wipro.cpastone.farmpartner.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "farm_partner")
public class FarmPartner {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long partnerId;

	    private String name;
	    
	    private String email;

	    private String location;

	    private String contactInfo;

		public FarmPartner() {
			super();
			// TODO Auto-generated constructor stub
		}

		public FarmPartner(Long partnerId, String name, String email, String location, String contactInfo) {
			super();
			this.partnerId = partnerId;
			this.name = name;
			this.email = email;
			this.location = location;
			this.contactInfo = contactInfo;
		}

		public Long getPartnerId() {
			return partnerId;
		}

		public void setPartnerId(Long partnerId) {
			this.partnerId = partnerId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getContactInfo() {
			return contactInfo;
		}

		public void setContactInfo(String contactInfo) {
			this.contactInfo = contactInfo;
		}

		@Override
		public String toString() {
			return "FarmPartner [partnerId=" + partnerId + ", name=" + name + ", email=" + email + ", location="
					+ location + ", contactInfo=" + contactInfo + "]";
		}

		
	    
}

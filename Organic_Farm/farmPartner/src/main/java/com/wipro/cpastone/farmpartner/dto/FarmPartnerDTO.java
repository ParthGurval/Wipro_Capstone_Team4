package com.wipro.cpastone.farmpartner.dto;

public class FarmPartnerDTO {

	private Long partnerId;
    private String name;
    private String location;
    private String contactInfo;
    
    
	public FarmPartnerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FarmPartnerDTO(Long partnerId, String name, String location, String contactInfo) {
		super();
		this.partnerId = partnerId;
		this.name = name;
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
		return "FarmPartnerDTO [partnerId=" + partnerId + ", name=" + name + ", location=" + location + ", contactInfo="
				+ contactInfo + "]";
	}
    
    
}

package com.wipro.capstone.admin.service;

import java.util.List;

import com.wipro.capstone.admin.dto.AdminDTO;
import com.wipro.capstone.admin.dto.Customer;
import com.wipro.capstone.admin.dto.FarmPartner;

public interface IAdminService {

	AdminDTO createAdmin(AdminDTO adminDTO);
	
    List<AdminDTO> getAllAdmins();
    
    AdminDTO getAdminById(Long id);
    
    AdminDTO updateAdmin(Long id, AdminDTO adminDTO);
    
    void deleteAdmin(Long id);
    
    
    
    // Customer management
    List<Customer> getAllCustomers();
    
    Customer getCustomerById(Long id);
    
    void deleteCustomerById(Long id);

    // FarmPartner management
    List<FarmPartner> getAllFarmPartners();
    
    FarmPartner getFarmPartnerById(Long id);
    
    void deleteFarmPartnerById(Long id);
}



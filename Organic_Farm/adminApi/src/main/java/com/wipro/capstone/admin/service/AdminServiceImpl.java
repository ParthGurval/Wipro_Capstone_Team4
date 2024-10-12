package com.wipro.capstone.admin.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.capstone.admin.dto.AdminDTO;
import com.wipro.capstone.admin.dto.Customer;
import com.wipro.capstone.admin.dto.FarmPartner;
import com.wipro.capstone.admin.entity.Admin;
import com.wipro.capstone.admin.repository.AdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${customer.api.url}")
    private String customerApiUrl;
    
    private final String USER_SERVICE_URL = "http://localhost:8484/api/farmpartners";

    @Override
    public AdminDTO createAdmin(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setUsername(adminDTO.getUsername());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword()); // Ensure this is hashed
        admin.setRole(adminDTO.getRole());
        admin.setContactInfo(adminDTO.getContactInfo());
        admin.setAddress(adminDTO.getAddress());

        Admin savedAdmin = adminRepository.save(admin);
        adminDTO.setAdminId(savedAdmin.getAdminId());
        return adminDTO;
    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }

    @Override
    public AdminDTO getAdminById(Long id) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            return convertEntityToDTO(admin);
        }
        return null; // Consider throwing a custom exception
    }

    @Override
    public AdminDTO updateAdmin(Long id, AdminDTO adminDTO) {
        Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            admin.setUsername(adminDTO.getUsername());
            admin.setEmail(adminDTO.getEmail());
            admin.setPassword(adminDTO.getPassword()); // Ensure this is hashed
            admin.setRole(adminDTO.getRole());
            admin.setContactInfo(adminDTO.getContactInfo());
            admin.setAddress(adminDTO.getAddress());

            Admin updatedAdmin = adminRepository.save(admin);
            return convertEntityToDTO(updatedAdmin);
        }
        return null; // Consider throwing a custom exception
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

//    @Override
//    public List<Customer> getAllCustomers() {
//        try {
//            Customer[] customers = restTemplate.getForObject(customerApiUrl + "/getAllCustomer", Customer[].class);
//            return Arrays.asList(customers);
//        } catch (Exception e) {
//            // Handle exceptions (e.g., CustomerApi is down)
//            e.printStackTrace();
//            return null; // Or throw a custom exception
//        }
//    }
    
    public List<Customer> getAllCustomers() {
    	
    	Customer[] customers = restTemplate.getForObject("http://localhost:8787/api/customers/getAllCustomer", Customer[].class);
    	
    	return Arrays.asList(customers); 
    }

//    @Override
//    public Customer getCustomerById(Long id) {
//        try {
//            return restTemplate.getForObject(customerApiUrl + "/getCustById/" + id, Customer.class);
//        } catch (Exception e) {
//            // Handle exceptions (e.g., Customer not found)
//            e.printStackTrace();
//            return null; // Or throw a custom exception
//        }
//    }
    
    public Customer getCustomerById(Long id) {
    	
    	return restTemplate.getForObject("http://localhost:8787/api/customers/getCustById/" + id, Customer.class);
    }

    @Override
    public void deleteCustomerById(Long id) {
        try {
            restTemplate.delete(customerApiUrl + "/deleteById/" + id);
        } catch (Exception e) {
            // Handle exceptions (e.g., Customer not found)
            e.printStackTrace();
            // Optionally throw a custom exception
        }
    }

    private AdminDTO convertEntityToDTO(Admin admin) {
        AdminDTO dto = new AdminDTO();
        dto.setAdminId(admin.getAdminId());
        dto.setUsername(admin.getUsername());
        dto.setEmail(admin.getEmail());
        dto.setPassword(admin.getPassword());
        dto.setRole(admin.getRole());
        dto.setContactInfo(admin.getContactInfo());
        dto.setAddress(admin.getAddress());
        return dto;
    }

	@Override
	public List<FarmPartner> getAllFarmPartner() {
		// TODO Auto-generated method stub
		FarmPartner[] farmPartners = restTemplate.getForObject("http://localhost:8484/api/farmpartners/getallPartner", FarmPartner[].class);
		return Arrays.asList(farmPartners);
	}

	@Override
	public FarmPartner getFarmPartnerById(Long id) {
		// TODO Auto-generated method stub

		return restTemplate.getForObject("http://localhost:8484/api/farmpartners/getbyid/" + id, FarmPartner.class);
	}

	@Override
	public String deleteFarmPartnerById(Long id) {
		// TODO Auto-generated method stub
		
		 restTemplate.delete("http://localhost:8484/api/farmpartners/deletebyid/" + id, FarmPartner.class);
	
		 return "Record Deleted by Admin For FarmPartner ID:  " + id;
	}
}

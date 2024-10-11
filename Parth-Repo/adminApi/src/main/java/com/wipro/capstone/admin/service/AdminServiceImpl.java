package com.wipro.capstone.admin.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
	RestTemplate restTemplate;
	
	@Override
	public AdminDTO createAdmin(AdminDTO adminDTO) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
        admin.setUsername(adminDTO.getUsername());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword()); // Hashed password
        admin.setRole(adminDTO.getRole());
        admin.setContactInfo(adminDTO.getContactInfo());
        admin.setAddress(adminDTO.getAddress());
        admin.setCustomerId(adminDTO.getCustomerId());
        
        Admin savedAdmin = adminRepository.save(admin);
        adminDTO.setAdminId(savedAdmin.getAdminId());
        return adminDTO;
	}

	@Override
	public List<AdminDTO> getAllAdmins() {
		// TODO Auto-generated method stub
		 List<Admin> admins = adminRepository.findAll();
	     return admins.stream().map(this::convertEntityToDTO).collect(Collectors.toList());
	}

	@Override
	public AdminDTO getAdminById(Long id) {
		// TODO Auto-generated method stub
		 Admin admin = adminRepository.findById(id).orElse(null);
	        if (admin != null) {
	            return convertEntityToDTO(admin);
	        }
	        return null;
	}

	@Override
	public AdminDTO updateAdmin(Long id, AdminDTO adminDTO) {
		// TODO Auto-generated method stub
		Admin admin = adminRepository.findById(id).orElse(null);
        if (admin != null) {
            admin.setUsername(adminDTO.getUsername());
            admin.setEmail(adminDTO.getEmail());
            admin.setPassword(adminDTO.getPassword());
            admin.setRole(adminDTO.getRole());
            admin.setContactInfo(adminDTO.getContactInfo());
            admin.setAddress(adminDTO.getAddress());
            admin.setCustomerId(adminDTO.getCustomerId());

            Admin updatedAdmin = adminRepository.save(admin);
            return convertEntityToDTO(updatedAdmin);
        }
        return null;
	}

	@Override
	public void deleteAdmin(Long id) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(id);
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
        dto.setCustomerId(admin.getCustomerId());
        return dto;
    }

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		
		Customer customer = new Customer();
		
		Long customerId = customer.getCustomerId();
		
		Customer customerTemp = restTemplate.getForObject("http://localhost:8787/api/customers/getCustById/" + id, Customer.class);
		
		return customerTemp;
	}

	@Override
	public void deleteCustomerById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FarmPartner> getAllFarmPartners() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FarmPartner getFarmPartnerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFarmPartnerById(Long id) {
		// TODO Auto-generated method stub
		
	}

}

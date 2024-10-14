package com.wipro.capstone.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.capstone.admin.dto.AdminDTO;
import com.wipro.capstone.admin.dto.Customer;
import com.wipro.capstone.admin.dto.FarmPartner;
import com.wipro.capstone.admin.service.IAdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    // Admin CRUD endpoints
    @PostMapping("/createAdmin")
    public AdminDTO createAdmin(@RequestBody AdminDTO adminDTO) {
        return adminService.createAdmin(adminDTO);
    }

    @GetMapping("/getAllAdmins")
    public List<AdminDTO> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/getAdminById/{id}")
    public AdminDTO getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PutMapping("/updateAdmin/{id}")
    public AdminDTO updateAdmin(@PathVariable Long id, @RequestBody AdminDTO adminDTO) {
        return adminService.updateAdmin(id, adminDTO);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "Admin with ID: " + id + " deleted successfully.";
    }

    // Customer management endpoints
    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    @GetMapping("/getCustomerById/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return adminService.getCustomerById(id);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomerById(@PathVariable Long id) {
        adminService.deleteCustomerById(id);
        return "Customer with ID: " + id + " deleted successfully.";
    }
    
    @GetMapping("/getAllFarmpPartners")
    public List<FarmPartner> getAllFarmPArtners() {
    	
    	return adminService.getAllFarmPartner();
    }
    
    @GetMapping("/getFarmPartById/{id}")
    public FarmPartner getFarmPartnerById(@PathVariable Long id) {
    	
    	return adminService.getFarmPartnerById(id);
    }
    
    @DeleteMapping("/deleteFarmPartById/{id}")
    public String deleteFarmPartnerById(@PathVariable Long id) {
    	
    	return adminService.deleteFarmPartnerById(id);
    }
}

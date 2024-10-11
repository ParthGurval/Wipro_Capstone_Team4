package com.wipro.capstone.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.capstone.admin.dto.AdminDTO;
import com.wipro.capstone.admin.dto.Customer;
import com.wipro.capstone.admin.service.IAdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
    private IAdminService adminService;

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
    
//    @GetMapping(value="/getCustById/{id}")
//    public Customer getCustomerById(@PathVariable Long id) {
//    	return adminService.getCustomerById(id);
//    }
    
    @GetMapping("/getCustById/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return adminService.getCustomerById(id);
    }
}

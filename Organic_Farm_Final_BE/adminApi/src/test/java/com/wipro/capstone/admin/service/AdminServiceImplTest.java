package com.wipro.capstone.admin.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.wipro.capstone.admin.dto.AdminDTO;
import com.wipro.capstone.admin.dto.Customer;
import com.wipro.capstone.admin.entity.Admin;
import com.wipro.capstone.admin.repository.AdminRepository;

class AdminServiceImplTest {

	@InjectMocks
    private AdminServiceImpl adminService;

    @Mock
    private AdminRepository adminRepository;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateAdmin() {
        // Arrange
        AdminDTO adminDTO = new AdminDTO(1L, "admin", "admin@example.com", "password", "ROLE_ADMIN", "1234567890", "Address");
        Admin admin = new Admin(1L, "admin", "admin@example.com", "password", "ROLE_ADMIN", "1234567890", "Address", "1");

        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        // Act
        AdminDTO result = adminService.createAdmin(adminDTO);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getAdminId());
        assertEquals("admin", result.getUsername());
    }

    @Test
    void testGetAllAdmins() {
        // Arrange
        List<Admin> admins = Arrays.asList(
                new Admin(1L, "admin1", "admin1@example.com", "password", "ROLE_ADMIN", "1234567890", "Address1", "1"),
                new Admin(2L, "admin2", "admin2@example.com", "password", "ROLE_ADMIN", "0987654321", "Address2", "2")
        );

        when(adminRepository.findAll()).thenReturn(admins);

        // Act
        List<AdminDTO> result = adminService.getAllAdmins();

        // Assert
        assertEquals(2, result.size());
        assertEquals("admin1", result.get(0).getUsername());
        assertEquals("admin2", result.get(1).getUsername());
    }

    @Test
    void testGetAdminById() {
        // Arrange
        Admin admin = new Admin(1L, "admin1", "admin1@example.com", "password", "ROLE_ADMIN", "1234567890", "Address1", "1");
        when(adminRepository.findById(1L)).thenReturn(Optional.of(admin));

        // Act
        AdminDTO result = adminService.getAdminById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("admin1", result.getUsername());
    }

    @Test
    void testUpdateAdmin() {
        // Arrange
        AdminDTO adminDTO = new AdminDTO(1L, "adminUpdated", "admin1@example.com", "newPassword", "ROLE_ADMIN", "1234567890", "New Address");
        Admin existingAdmin = new Admin(1L, "admin1", "admin1@example.com", "password", "ROLE_ADMIN", "1234567890", "Address1", "1");
        
        when(adminRepository.findById(1L)).thenReturn(Optional.of(existingAdmin));
        when(adminRepository.save(any(Admin.class))).thenReturn(existingAdmin);

        // Act
        AdminDTO result = adminService.updateAdmin(1L, adminDTO);

        // Assert
        assertNotNull(result);
        assertEquals("adminUpdated", result.getUsername());
    }

    @Test
    void testDeleteAdmin() {
        // Arrange
        Long adminIdToDelete = 1L;

        // Act
        adminService.deleteAdmin(adminIdToDelete);

        // Assert
        verify(adminRepository, times(1)).deleteById(adminIdToDelete);
    }

    @Test
    void testGetAllCustomers() {
        // Arrange
        Customer[] customers = { new Customer(/* initialize customer object */) };
        when(restTemplate.getForObject(anyString(), eq(Customer[].class))).thenReturn(customers);

        // Act
        List<Customer> result = adminService.getAllCustomers();

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        // Further assertions for the Customer object can be done here
    }

    @Test
    void testGetCustomerById() {
        // Arrange
        Customer customer = new Customer(/* initialize customer object */);
        when(restTemplate.getForObject(anyString(), eq(Customer.class))).thenReturn(customer);

        // Act
        Customer result = adminService.getCustomerById(1L);

        // Assert
        assertNotNull(result);
        // Further assertions for the Customer object can be done here
    }

    @Test
    void testDeleteCustomerById() {
        // Arrange
        Long customerIdToDelete = 1L;

        // Act
        adminService.deleteCustomerById(customerIdToDelete);

        // Assert
        verify(restTemplate, times(1)).delete(anyString());
    }
}
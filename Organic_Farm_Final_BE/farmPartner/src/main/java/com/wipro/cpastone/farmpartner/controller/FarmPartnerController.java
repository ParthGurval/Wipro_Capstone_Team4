package com.wipro.cpastone.farmpartner.controller;

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

import com.wipro.cpastone.farmpartner.dto.FarmPartnerDTO;
import com.wipro.cpastone.farmpartner.dto.Product;
import com.wipro.cpastone.farmpartner.entity.FarmPartner;
import com.wipro.cpastone.farmpartner.service.FarmPartnerService;

@RestController
@RequestMapping("/api/farmpartners")
public class FarmPartnerController {

    @Autowired
    private FarmPartnerService farmPartnerService;
    
    @PostMapping(value="/createPartner")
    public FarmPartner createPartner(@RequestBody FarmPartnerDTO farmPartnerDTO){
    	
    	return farmPartnerService.createFarmPartner(farmPartnerDTO);
    }
    
	@GetMapping(value="/getbyid/{partnerId}")
	public FarmPartnerDTO getPartnerById(@PathVariable Long partnerId) {
		
		return farmPartnerService.getFarmPartnerById(partnerId);
	}
	
	@GetMapping("/getallPartner")
	public List<FarmPartner> getAllPartner(){
		
		return farmPartnerService.getAllFarmPartners();
	}
	
//	@PutMapping("/updatePartner")
//	public FarmPartner updateEmp(@RequestBody FarmPartnerDTO farmPartnerDTO) {
//		
//		return farmPartnerService.updateFarmPartner(farmPartnerDTO);
//	}
	
    @PutMapping("/updatePartner/{id}")
    public FarmPartner updatePartner(@PathVariable Long id, @RequestBody FarmPartnerDTO farmPartnerDTO) {
        farmPartnerDTO.setPartnerId(id);  // Ensure the ID is set from the path variable
        return farmPartnerService.updateFarmPartner(farmPartnerDTO);
    }
	
	@DeleteMapping("/deletebyid/{partnerId}")
	public String deleteVehicleById(@PathVariable Long partnerId) {
		
		return farmPartnerService.deleteFarmPartner(partnerId);
	}
	
	@PostMapping("/createProduct")
	public Product createProduct(@RequestBody Product product) {
		
		return farmPartnerService.createProduct(product);
	}
	
	@PutMapping("/updateProduct/{productId}")
	public Product updateProductById(@PathVariable Long productId, @RequestBody Product product){
		
		return farmPartnerService.updateProduct(productId, product);
	}
	
	@GetMapping("/getProductById/{productId}")
	public Product getProductById(@PathVariable Long productId) {
		
		return farmPartnerService.getProductById(productId);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProduct(){
		
		return farmPartnerService.getAllProduct();
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteProductById(@PathVariable Long productId) {
		
		return farmPartnerService.deleteProductById(productId);
	}
	
}

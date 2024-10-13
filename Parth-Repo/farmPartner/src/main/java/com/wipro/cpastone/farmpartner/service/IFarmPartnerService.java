package com.wipro.cpastone.farmpartner.service;

import java.util.List;

import com.wipro.cpastone.farmpartner.dto.FarmPartnerDTO;
import com.wipro.cpastone.farmpartner.dto.Product;
import com.wipro.cpastone.farmpartner.entity.FarmPartner;

public interface IFarmPartnerService {

	public FarmPartner createFarmPartner(FarmPartnerDTO farmPartnerDTO);
	
    public FarmPartnerDTO getFarmPartnerById(Long partnerId);
    
    public List<FarmPartner> getAllFarmPartners();
    
    public FarmPartner updateFarmPartner(FarmPartnerDTO farmPartnerDTO);
    
    public String deleteFarmPartner(Long partnerId);
    
    
    //For Products
    
    public Product createProduct(Product product);
    
    public Product updateProduct(Long productId, Product product);
    
    public Product getProductById(Long productId);
    
    public List<Product> getAllProduct();
    
    public String deleteProductById(Long productId);
}

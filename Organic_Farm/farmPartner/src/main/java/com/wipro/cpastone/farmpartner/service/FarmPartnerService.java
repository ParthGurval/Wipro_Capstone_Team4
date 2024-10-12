package com.wipro.cpastone.farmpartner.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.cpastone.farmpartner.dto.FarmPartnerDTO;
import com.wipro.cpastone.farmpartner.dto.Product;
import com.wipro.cpastone.farmpartner.entity.FarmPartner;
import com.wipro.cpastone.farmpartner.exception.ResourceNotFoundException;
import com.wipro.cpastone.farmpartner.repository.FarmPartnerRepository;

@Service
public class FarmPartnerService implements IFarmPartnerService {
	
	@Autowired
    private FarmPartnerRepository farmPartnerRepository;
	
    @Autowired
    private RestTemplate restTemplate;

    private final String PRODUCT_SERVICE_URL = "http://localhost:8989/api/products/";
    
    
	@Override
	public FarmPartner createFarmPartner(FarmPartnerDTO farmPartnerDTO) {
		// TODO Auto-generated method stub
		
		FarmPartner farmPartner = new FarmPartner();
		
        farmPartner.setName(farmPartnerDTO.getName());
        farmPartner.setEmail(farmPartnerDTO.getEmail());
        farmPartner.setLocation(farmPartnerDTO.getLocation());
        farmPartner.setContactInfo(farmPartnerDTO.getContactInfo());

//        FarmPartner savedFarmPartner = farmPartnerRepository.save(farmPartner);
//        
//        farmPartnerDTO.setPartnerId(savedFarmPartner.getPartnerId());

        return farmPartnerRepository.save(farmPartner);
	}

	@Override
	public FarmPartnerDTO getFarmPartnerById(Long partnerId) {
		// TODO Auto-generated method stub
		
//		FarmPartner farmPartner = farmPartnerRepository.findById(partnerId).orElse(null);
//		
//		FarmPartnerDTO farmPartnerDto = new FarmPartnerDTO();
//		
//		farmPartnerDto.setPartnerId(farmPartner.getPartnerId());
//		farmPartnerDto.setName(farmPartner.getName());
//		farmPartnerDto.setLocation(farmPartner.getLocation());
//		farmPartnerDto.setContactInfo(farmPartner.getContactInfo());
//		
//		return farmPartnerDto;
		
		Optional<FarmPartner> optionalFarmPartner = farmPartnerRepository.findById(partnerId);
        if (optionalFarmPartner.isPresent()) {
            FarmPartner farmPartner = optionalFarmPartner.get();
            FarmPartnerDTO farmPartnerDto = new FarmPartnerDTO();
            farmPartnerDto.setPartnerId(farmPartner.getPartnerId());
            farmPartnerDto.setName(farmPartner.getName());
            farmPartnerDto.setEmail(farmPartner.getEmail());
            farmPartnerDto.setLocation(farmPartner.getLocation());
            farmPartnerDto.setContactInfo(farmPartner.getContactInfo());
            return farmPartnerDto;
        } else {
            // Handle the case where the entity is not found
            throw new ResourceNotFoundException("FarmPartner not found with ID: " + partnerId);
        }
	}

	@Override
	public List<FarmPartner> getAllFarmPartners() {
		// TODO Auto-generated method stub
		return farmPartnerRepository.findAll();
	}

	@Override
	public FarmPartner updateFarmPartner(FarmPartnerDTO farmPartnerDTO) {
		// TODO Auto-generated method stub
		
//		FarmPartner farmPartner = new FarmPartner();
//		
//		farmPartner.setPartnerId(farmPartnerDTO.getPartnerId());
//		farmPartner.setName(farmPartnerDTO.getName());
//		farmPartner.setLocation(farmPartnerDTO.getLocation());
//		farmPartner.setContactInfo(farmPartnerDTO.getContactInfo());
//		
//		return farmPartnerRepository.save(farmPartner);
		
	    Long partnerId = farmPartnerDTO.getPartnerId();
	    if (partnerId == null) {
	        throw new IllegalArgumentException("Partner ID must not be null for update.");
	    }

	    // Fetch the existing FarmPartner
	    FarmPartner existingFarmPartner = farmPartnerRepository.findById(partnerId)
	            .orElseThrow(() -> new ResourceNotFoundException("FarmPartner not found with ID: " + partnerId));

	    // Update the fields
	    existingFarmPartner.setName(farmPartnerDTO.getName());
	    existingFarmPartner.setEmail(farmPartnerDTO.getEmail());
	    existingFarmPartner.setLocation(farmPartnerDTO.getLocation());
	    existingFarmPartner.setContactInfo(farmPartnerDTO.getContactInfo());

	    // Save the updated entity
	    return farmPartnerRepository.save(existingFarmPartner);
	}

	@Override
	public String deleteFarmPartner(Long partnerId) {
		// TODO Auto-generated method stub
		
		farmPartnerRepository.deleteById(partnerId);
		
		return "Record Deleted For FarmPartner ID: " + partnerId;
	}

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub

		return restTemplate.postForObject("http://localhost:8989/api/products/createProduct", product, Product.class);
	}

	@Override
	public Product updateProduct(Long productId, Product product) {
		// TODO Auto-generated method stub
		
		String url = PRODUCT_SERVICE_URL + "updateProduct/" + productId;
		restTemplate.put(url, product);
		return getProductById(productId);
	}

	@Override
	public Product getProductById(Long productId) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject("http://localhost:8989/api/products/getProductById/" + productId, Product.class);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		
		Product[] products = restTemplate.getForObject("http://localhost:8989/api/products/getAllProducts", Product[].class);
		return Arrays.asList(products);
	}

	@Override
	public String deleteProductById(Long productId) {
		// TODO Auto-generated method stub
		
		restTemplate.delete("http://localhost:8989/api/products/deleteProduct/" + productId, Product.class);
		
		return "Record Deleted by FarmPartner For Product ID:  " + productId;
	}

}

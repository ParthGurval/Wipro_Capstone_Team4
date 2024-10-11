package com.wipro.capstone.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.capstone.product.dto.ProductDTO;
import com.wipro.capstone.product.entity.Product;
import com.wipro.capstone.product.entity.ProductType;
import com.wipro.capstone.product.exception.ResourceNotFoundException;
import com.wipro.capstone.product.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	 @Autowired
	    private ProductRepository productRepository;	
	
	@Override
	public ProductDTO createProduct(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		
		 Product product = new Product();
	        product.setName(productDTO.getName());
	        product.setType(ProductType.valueOf(productDTO.getType().toUpperCase())); // Ensure type is capitalized
	        product.setPrice(productDTO.getPrice());
	        product.setAvailableQuantity(productDTO.getAvailableQuantity());
	        product.setPartnerId(productDTO.getPartnerId());

	        productRepository.save(product); // Save product
	        productDTO.setProductId(product.getProductId()); // Set ID in DTO
	        return productDTO; // Return DTO
	        
	        
	        
	}

	@Override
	public ProductDTO getProductById(Long id) {
		// TODO Auto-generated method stub
		Optional<Product> optionalProduct = productRepository.findById(id);
		
        if (optionalProduct.isPresent()) {
        	
            Product product = optionalProduct.get();
            ProductDTO dto = new ProductDTO();
            dto.setProductId(product.getProductId());
            dto.setName(product.getName());
            dto.setType(product.getType().name());
            dto.setPrice(product.getPrice());
            dto.setAvailableQuantity(product.getAvailableQuantity());
            dto.setPartnerId(product.getPartnerId());
            return dto; // Return found DTO
            
        } 
        
        else {
            throw new ResourceNotFoundException("Product not found with ID: " + id); // Throw exception if not found
        }
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();

        for (Product product : products) {
            ProductDTO dto = new ProductDTO();
            dto.setProductId(product.getProductId());
            dto.setName(product.getName());
            dto.setType(product.getType().name());
            dto.setPrice(product.getPrice());
            dto.setAvailableQuantity(product.getAvailableQuantity());
            dto.setPartnerId(product.getPartnerId());
            productDTOs.add(dto); // Add DTO to the list
        }

        return productDTOs; // Return the list of DTOs
	}

	@Override
	public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
		// TODO Auto-generated method stub
		 Long productId = productDTO.getProductId();
	        if (productId == null) {
	            throw new IllegalArgumentException("Product ID must not be null for update.");
	        }

	        // Fetch the existing Product
	        Product existingProduct = productRepository.findById(productId)
	                .orElseThrow(() -> new ResourceNotFoundException("Product not found with ID: " + productId));

	        // Update the fields
	        existingProduct.setName(productDTO.getName());
	        existingProduct.setType(ProductType.valueOf(productDTO.getType().toUpperCase()));
	        existingProduct.setPrice(productDTO.getPrice());
	        existingProduct.setAvailableQuantity(productDTO.getAvailableQuantity());
	        existingProduct.setPartnerId(productDTO.getPartnerId());

	        // Save the updated entity
	        productRepository.save(existingProduct); // Save the existing product
	        return productDTO; // Return the updated DTO
	}

	@Override
	public String deleteProduct(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id); // Delete product by ID
        return "Record Deleted For Product ID: " + id; // Return deletion message
	}

}

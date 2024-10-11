package com.wipro.capstone.product.service;

import java.util.List;

import com.wipro.capstone.product.dto.ProductDTO;

public interface IProductService {

	 	public ProductDTO createProduct(ProductDTO productDTO);
	    
	    public ProductDTO getProductById(Long id);
	    
	    public List<ProductDTO> getAllProducts();
	    
	    public ProductDTO updateProduct(Long id, ProductDTO productDTO);
	    
	    public String deleteProduct(Long id);
}

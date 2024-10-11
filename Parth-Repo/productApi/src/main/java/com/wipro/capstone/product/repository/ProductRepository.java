package com.wipro.capstone.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.capstone.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

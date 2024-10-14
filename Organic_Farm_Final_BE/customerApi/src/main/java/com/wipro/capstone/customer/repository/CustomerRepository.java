package com.wipro.capstone.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.capstone.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

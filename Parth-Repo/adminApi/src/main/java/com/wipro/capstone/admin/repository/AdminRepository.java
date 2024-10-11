package com.wipro.capstone.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.capstone.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}

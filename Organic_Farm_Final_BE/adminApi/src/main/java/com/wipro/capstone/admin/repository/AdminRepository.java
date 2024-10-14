package com.wipro.capstone.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.capstone.admin.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}

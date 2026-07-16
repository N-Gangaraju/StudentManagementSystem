package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entites.Admin;

public interface AdminRepo  extends JpaRepository<Admin,Integer>{
	
	Admin findByUsername(String username);
}

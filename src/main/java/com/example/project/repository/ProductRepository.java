package com.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>  {
//JpaRepository internally provides @Repository annotation
	
}

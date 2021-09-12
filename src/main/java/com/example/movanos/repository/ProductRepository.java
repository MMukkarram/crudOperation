package com.example.movanos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.example.movanos.entity.Product;


public interface ProductRepository extends JpaRepository<Product , Integer> {

    Product findByName(String name);
}

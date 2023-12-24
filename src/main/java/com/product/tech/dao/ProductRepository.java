package com.product.tech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.tech.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

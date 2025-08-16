package com.icshop7.delivery.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.icshop7.delivery.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}

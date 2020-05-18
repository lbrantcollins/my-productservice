package com.allstate.tddspringjunit5.myproductservice.repository;

import com.allstate.tddspringjunit5.myproductservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> { }

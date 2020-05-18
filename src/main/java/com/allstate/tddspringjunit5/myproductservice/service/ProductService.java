package com.allstate.tddspringjunit5.myproductservice.service;

import com.allstate.tddspringjunit5.myproductservice.model.Product;
import com.allstate.tddspringjunit5.myproductservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Optional<Product> findById(Integer id) {
        return repository.findById(id);
    }


}

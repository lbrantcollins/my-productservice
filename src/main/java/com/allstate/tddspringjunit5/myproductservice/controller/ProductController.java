package com.allstate.tddspringjunit5.myproductservice.controller;

import com.allstate.tddspringjunit5.myproductservice.model.Product;
import com.allstate.tddspringjunit5.myproductservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository repository;

    @GetMapping(value = "/product/{id}")
    public Optional<Product> findById(@PathVariable Integer id) {
        // TODO: Need to set up a service with a findById method to handle the possibility that the ID is not found (rather than using an Optional here)
        // TODO: Getting a null pointer exception here...
        return repository.findById(id);
    }

}

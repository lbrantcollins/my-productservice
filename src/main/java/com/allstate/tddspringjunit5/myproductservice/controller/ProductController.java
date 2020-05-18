package com.allstate.tddspringjunit5.myproductservice.controller;

import com.allstate.tddspringjunit5.myproductservice.model.Product;
import com.allstate.tddspringjunit5.myproductservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping(value = "/product/{id}")
    public Optional<Product> findById(@PathVariable Integer id) {
        return service.findById(id);
    }

}

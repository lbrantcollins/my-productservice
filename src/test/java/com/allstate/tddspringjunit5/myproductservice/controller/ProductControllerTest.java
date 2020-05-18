package com.allstate.tddspringjunit5.myproductservice.controller;

import com.allstate.tddspringjunit5.myproductservice.model.Product;
import com.allstate.tddspringjunit5.myproductservice.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService service;

    @InjectMocks
    private ProductController controller;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void findById_findsProductWhenProductExists() throws Exception {

        Product product = Product.builder()
                .id(2)
                .name("product")
                .quantity(10)
                .version(3)
                .build();

        when(service.findById(anyInt())).thenReturn(Optional.of(product));

        mockMvc.perform(get("/api/v1/product/{id}", 2))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset/UTF-8"))
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("product"))
                .andExpect(jsonPath("$.quantity").value(10))
                .andExpect(jsonPath("$.version").value(3));

        verify(service).findById(2);
    }

//    @Test
//    void findById_returnsEmptyProductWhenProductDoesNotExist() throws Exception {
//
//        when(service.findById(anyInt())).thenReturn(Optional.empty());
//
//        TODO: When product is not found, what should behavior be?
//        mockMvc.perform(get("/api/v1/product/{id}", 2))
//                .andExpect(status().isNotFound())
//                .andExpect(content().contentType("application/json;charset/UTF-8"));
//    }
}
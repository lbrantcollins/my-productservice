package com.allstate.tddspringjunit5.myproductservice.controller;

import com.allstate.tddspringjunit5.myproductservice.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ProductController controller;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void findById() throws Exception {

        Product product = Product.builder()
                .id(1)
                .name("product name")
                .quantity(10)
                .version(1)
                .build();

        // TODO: See note in the controller about removing the need to return an optional here
        when(controller.findById(anyInt())).thenReturn(Optional.of(product));

        mockMvc.perform(get("/product{id}", 1L))
                .andExpect(status().isOk());
    }
}
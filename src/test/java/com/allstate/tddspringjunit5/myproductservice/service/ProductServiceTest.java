package com.allstate.tddspringjunit5.myproductservice.service;

import com.allstate.tddspringjunit5.myproductservice.model.Product;
import com.allstate.tddspringjunit5.myproductservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    void findById_itReturnsProductWhenProductExists() {

        Optional<Product> expected = Optional.of(Product.builder().id(5).build());

        when(repository.findById(anyInt())).thenReturn(expected);

        Optional<Product> actual = service.findById(5);

        assertThat(actual).isEqualTo(expected);

        verify(repository).findById(5);
    }

    @Test
    void findById_itReturnsEmptyProductWhenProductDoesNotExist() {

        when(repository.findById(anyInt())).thenReturn(Optional.empty());

        Optional<Product> actual = service.findById(5);

        assertThat(actual).isEmpty();

        verify(repository).findById(5);
    }

}
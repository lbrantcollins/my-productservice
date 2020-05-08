package com.allstate.tddspringjunit5.myproductservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Integer id;
    private String name;
    private Integer quantity;
    private Integer version;
}

package com.imran.productservice.dto;

import com.imran.productservice.entity.Product;
import lombok.*;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }
}

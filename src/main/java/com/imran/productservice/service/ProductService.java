package com.imran.productservice.service;

import com.imran.productservice.dto.ProductRequest;
import com.imran.productservice.dto.ProductResponse;
import com.imran.productservice.entity.Product;
import com.imran.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product = Product
                .builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();
        productRepository.save(product);
        log.info("product saved successfully id: {} name: {}",product.getId(),product.getName());
    }

    public List<Product> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    public ProductResponse getProductById(String id) {
        Product product = productRepository.findById(id).orElseThrow();
        return new ProductResponse(product);
    }
}

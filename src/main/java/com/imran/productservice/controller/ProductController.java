package com.imran.productservice.controller;

import com.imran.productservice.dto.ProductRequest;
import com.imran.productservice.dto.ProductResponse;
import com.imran.productservice.entity.Product;
import com.imran.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<ProductResponse>> getAllProduct(){
        List<Product> products = productService.getAllProduct();
        List<ProductResponse> productResponses =
                products.stream().map(ProductResponse::new).collect(Collectors.toList());
        return new ResponseEntity<>(productResponses,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable (value = "id") String id1){
        return new ResponseEntity<>(productService.getProductById(id1),HttpStatus.OK);
    }


}

package com.imran.productservice.repository;

import com.imran.productservice.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    List<Product> findAll();

    @Override
    Optional<Product> findById(String s);
}

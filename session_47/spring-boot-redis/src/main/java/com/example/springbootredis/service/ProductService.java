package com.example.springbootredis.service;

import com.example.springbootredis.domain.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Product findProductById(Integer id);

    void deleteProduct(Integer id);
}

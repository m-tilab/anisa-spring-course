package com.example.springbootredis.service;

import com.example.springbootredis.domain.Product;
import com.example.springbootredis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;


    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {

        return repository.save(product);
    }

    @Override
    public List<Product> findAll() {

        return repository.findAll();
    }

    @Override
    public Product findProductById(Integer id) {

        return repository.findProductById(id);
    }

    @Override
    public void deleteProduct(Integer id) {
        repository.deleteProduct(id);
    }
}

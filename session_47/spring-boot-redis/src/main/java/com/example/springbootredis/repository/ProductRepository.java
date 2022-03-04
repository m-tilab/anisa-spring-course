package com.example.springbootredis.repository;

import com.example.springbootredis.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    public static final String KEY = "Product";
    private final RedisTemplate<String, Object> template;

    public ProductRepository(RedisTemplate<String, Object> template) {
        this.template = template;
    }

    public Product save(Product product) {

        HashOperations<String, Integer, Product> hashOperations = template.opsForHash();

        hashOperations.put(KEY, product.getId(), product);

        return product;
    }

    public List<Product> findAll() {

        HashOperations<String, Integer, Product> hashOperations = template.opsForHash();

        return hashOperations.values(KEY);
    }

    public Product findProductById(Integer id) {

        HashOperations<String, Integer, Product> hashOperations = template.opsForHash();

        return hashOperations.get(KEY, id);
    }

    public void deleteProduct(Integer id) {

        HashOperations<String, Integer, Product> hashOperations = template.opsForHash();

        hashOperations.delete(KEY, id);
    }
}

package com.example.springbootredis.controller;

import com.example.springbootredis.domain.Product;
import com.example.springbootredis.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {

        return productService.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {

        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {

        return productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Integer id) {

        productService.deleteProduct(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}

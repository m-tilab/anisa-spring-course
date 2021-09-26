package org.example.service;

import org.example.dao.ProductDao;
import org.example.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    static private Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductDao productDao;

    public void createSeedData() {

        Product product1 = new Product(0, "battery",
                "battery desc", 1220, 1600000, 1, 1,
                new Date());

        Product product2 = new Product(0, "potato chips",
                "potato chips desc", 155,1600000, 1, 1,
                new Date());

        Product product3 = new Product(0, "Playstation 4",
                "Playstation 4 desc", 100,1600000, 1, 1,
                new Date());

        var products = List.of(product1, product2, product3);

        products.stream().forEach(org -> productDao.create(org));

    }

    public void printProduct(Product product) {

        System.out.println("print Product ...." + product);
    }

    public void printProducts() {

        List<Product> products = getAllProducts();

        products.stream().forEach(org -> LOGGER.info(org.toString()));
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public void addProduct(String name, String description, int quantity, long price,
                                long productCategoryId, long creatorUserId, Date createDate) {

        Product product = new Product(0, name, description,
                quantity, price, productCategoryId, creatorUserId, createDate);

        productDao.create(product);

    }

    public Product getProduct(long ProductId) {

        return productDao.getProduct(ProductId);

    }

    public void updateProduct(long productId, String name, String description, int quantity,
                              long price, long productCategoryId, long creatorUserId, Date createDate) {

        Product product = new Product(productId, name, description,
                quantity, price, productCategoryId, creatorUserId, createDate);

        productDao.update(product);
    }

}

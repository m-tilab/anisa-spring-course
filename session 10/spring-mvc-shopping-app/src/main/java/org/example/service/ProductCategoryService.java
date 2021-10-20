package org.example.service;

import org.example.dao.ProductCategoryDao;
import org.example.domain.Product;
import org.example.domain.ProductCategory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductCategoryService {

    static private Logger LOGGER = LoggerFactory.getLogger(ProductCategoryService.class);

    @Autowired
    private ProductCategoryDao productCategoryDao;

    public void createSeedData() {

        ProductCategory product1 = new ProductCategory(0L,
                "battery", new Date());

        ProductCategory product2 = new ProductCategory(0L,
                "potato chips", new Date());

        ProductCategory product3 = new ProductCategory(0L,
                "Playstation 4", new Date());

        var products = List.of(product1, product2, product3);

        products.stream().forEach(org -> productCategoryDao.create(org));

    }

    public void printProduct(Product product) {

        System.out.println("print Product ...." + product);
    }

    public void printProductCategories() {

        List<ProductCategory> productCategories = getAllProductCategories();

        productCategories.stream().forEach(org -> LOGGER.info(org.toString()));
    }

    public List<ProductCategory> getAllProductCategories() {
        return productCategoryDao.getAllProductCategories();
    }

    public void addProductCategory(String name, Date createDate) {

        ProductCategory productCategory = new ProductCategory(0, name, createDate);

        productCategoryDao.create(productCategory);

    }

    public ProductCategory getProductCategory(long ProductId) {

        return productCategoryDao.getProductCategory(ProductId);

    }

    public void updateProduct(long productCategoryId, String name, Date createDate) {

        ProductCategory productCategory = new ProductCategory(productCategoryId,
                name, createDate);

        productCategoryDao.update(productCategory);
    }

}

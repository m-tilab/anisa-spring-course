package org.example.dao;

import org.example.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.util.List;

public interface ProductCategoryDao {
    @Autowired
    void setDataSource(DataSource dataSource);

    boolean create(ProductCategory productCategory);

    ProductCategory getProductCategory(long productCategoryId);

    List<ProductCategory> getAllProductCategories();

    boolean delete(ProductCategory productCategory);

    boolean update(ProductCategory productCategory);

    void cleanup();
}

package org.example.dao;

import org.example.domain.Product;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

public interface ProductDao {

    public void setDataSource(DataSource dataSource);

    public boolean create(Product product);

    public Product getProduct(long id);

    public List<Product> getAllProducts();

    public boolean delete(Product product);

    public boolean update(Product product);

    public void cleanup();



}

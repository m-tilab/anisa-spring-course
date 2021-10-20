package org.example.dao.impl;

import org.example.dao.ProductDao;
import org.example.dao.mapper.ProductRowMapper;
import org.example.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    @Override
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public boolean create(Product product) {

        String sqlQuery = "INSERT INTO Product(name, description, " +
                "quantity, price, productCategoryId, creatorUserId, createDate) VALUES(:name, :description, " +
                ":quantity, :price, :productCategoryId, :creatorUserId, :createDate)";

        SqlParameterSource params = new BeanPropertySqlParameterSource(product);

        return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
    }

    @Override
    public Product getProduct(long productId) {

        String sqlQuery = "SELECT * FROM Product WHERE productId =:productId";
        SqlParameterSource params = new MapSqlParameterSource("productId", productId);

        return namedParameterJdbcTemplate.queryForObject(sqlQuery, params, new ProductRowMapper());
    }

    @Override
    public List<Product> getAllProducts() {

        String sqlQuery = "SELECT * FROM Product";

        return namedParameterJdbcTemplate.query(sqlQuery, new ProductRowMapper());
    }

    @Override
    public boolean delete(Product product) {
        return false;
    }

    @Override
    public boolean update(Product product) {

        String sqlQuery = "UPDATE Product SET name = :name, " +
                "description = :description, " +
                "quantity = :quantity, " +
                "price = :price, " +
                "productCategoryId = :productCategoryId, " +
                "createDate = :createDate, " +
                "creatorUserId = :creatorUserId WHERE productId = :productId";

        SqlParameterSource params = new BeanPropertySqlParameterSource(product);

        return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
    }

    @Override
    public void cleanup() {

        String sqlQuery = "TRUNCATE TABLE Product";

        namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);

    }
}

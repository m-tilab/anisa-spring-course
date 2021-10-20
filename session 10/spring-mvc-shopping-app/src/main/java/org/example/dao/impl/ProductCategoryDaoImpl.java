package org.example.dao.impl;

import org.example.dao.ProductCategoryDao;
import org.example.dao.mapper.ProductCategoryRowMapper;
import org.example.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductCategoryDaoImpl implements ProductCategoryDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    @Override
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public boolean create(ProductCategory productCategory) {

        String sqlQuery = "INSERT INTO Product(name, description, " +
                "quantity, productCategoryId, creatorUserId, createDate) VALUES(:name, :description, " +
                ":quantity, :productCategoryId, :creatorUserId, :createDate)";

        SqlParameterSource params = new BeanPropertySqlParameterSource(productCategory);

        return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
    }

    @Override
    public ProductCategory getProductCategory(long productCategoryId) {

        if (productCategoryId == 0)
            return new ProductCategory();

        String sqlQuery = "SELECT * FROM ProductCategory WHERE productCategoryId =:productCategoryId";
        SqlParameterSource params = new MapSqlParameterSource("productCategoryId", productCategoryId);

        return namedParameterJdbcTemplate.queryForObject(sqlQuery, params, new ProductCategoryRowMapper());
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {

        String sqlQuery = "SELECT * FROM ProductCategory";

        return namedParameterJdbcTemplate.query(sqlQuery, new ProductCategoryRowMapper());
    }

    @Override
    public boolean delete(ProductCategory productCategory) {
        return false;
    }

    @Override
    public boolean update(ProductCategory productCategory) {

        String sqlQuery = "UPDATE Product SET name = :name, " +
                "description = :description, " +
                "quantity = :quantity, " +
                "productCategoryId = :productCategoryId, " +
                "createDate = :createDate, " +
                "creatorUserId = :creatorUserId WHERE productId = :productId";

        SqlParameterSource params = new BeanPropertySqlParameterSource(productCategory);

        return namedParameterJdbcTemplate.update(sqlQuery, params) == 1;
    }

    @Override
    public void cleanup() {

        String sqlQuery = "TRUNCATE TABLE Product";

        namedParameterJdbcTemplate.getJdbcOperations().execute(sqlQuery);

    }
}

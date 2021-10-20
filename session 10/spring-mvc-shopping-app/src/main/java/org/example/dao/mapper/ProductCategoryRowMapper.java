package org.example.dao.mapper;

import org.example.domain.ProductCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductCategoryRowMapper implements RowMapper<ProductCategory> {
    @Override
    public ProductCategory mapRow(ResultSet resultSet, int i) throws SQLException {

        ProductCategory productCategory = new ProductCategory();

        productCategory.setProductCategoryId(resultSet.getLong("productCategoryId"));
        productCategory.setName(resultSet.getString("name"));
        productCategory.setCreateDate(resultSet.getDate("createDate"));

        return productCategory;
    }
}

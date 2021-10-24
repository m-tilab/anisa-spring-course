package org.example.dao.mapper;

import org.example.domain.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {

        Product product = new Product();

        product.setProductId(resultSet.getLong("productId"));
        product.setName(resultSet.getString("name"));
        product.setDescription(resultSet.getString("description"));
        product.setQuantity(resultSet.getInt("quantity"));
        product.setPrice(resultSet.getLong("price"));
        product.setProductCategoryId(resultSet.getLong("productCategoryId"));
        product.setCreatorUserId(resultSet.getInt("creatorUserId"));
        product.setCreateDate(resultSet.getDate("createDate"));

        return product;
    }
}

package org.example.dao.impl;

import org.example.domain.Organization;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationRowMapper implements RowMapper<Organization> {
    @Override
    public Organization mapRow(ResultSet resultSet, int i) throws SQLException {

        Organization organization = new Organization();

        organization.setId(resultSet.getInt("id"));
        organization.setCompanyName(resultSet.getString("company_name"));
        organization.setYearOfIncorporation(resultSet.getInt("year_of_incorporation"));
        organization.setPostalCode(resultSet.getInt("postal_code"));
        organization.setEmployeeCount(resultSet.getInt("employee_count"));
        organization.setSlogan(resultSet.getString("slogan"));

        return organization;
    }
}

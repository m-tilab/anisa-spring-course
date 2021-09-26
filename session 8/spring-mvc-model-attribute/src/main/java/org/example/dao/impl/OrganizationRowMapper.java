package org.example.dao.impl;

import org.example.domain.Organization;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationRowMapper implements RowMapper<Organization> {
    @Override
    public Organization mapRow(ResultSet resultSet, int i) throws SQLException {

        Organization organization = new Organization();

        organization.setOrganizationId(resultSet.getInt("organizationId"));
        organization.setCompanyName(resultSet.getString("companyName"));
        organization.setYearOfIncorporation(resultSet.getInt("yearOfIncorporation"));
        organization.setPostalCode(resultSet.getInt("postalCode"));
        organization.setEmployeeCount(resultSet.getInt("employeeCount"));
        organization.setSlogan(resultSet.getString("slogan"));

        return organization;
    }
}

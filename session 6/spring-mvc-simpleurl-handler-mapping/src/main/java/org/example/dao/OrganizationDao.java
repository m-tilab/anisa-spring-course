package org.example.dao;

import org.example.domain.Organization;

import javax.sql.DataSource;
import java.util.List;

public interface OrganizationDao {

    public void setDataSource(DataSource dataSource);

    public boolean create(Organization organization);

    public Organization getOrganization(int id);

    public List<Organization> getAllOrganizations();

    public boolean delete(Organization organization);

    public boolean update(Organization organization);

    public void cleanup();



}

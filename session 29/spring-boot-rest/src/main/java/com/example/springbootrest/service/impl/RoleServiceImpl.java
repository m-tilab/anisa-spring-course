package com.example.springbootrest.service.impl;

import com.example.springbootrest.model.dto.RoleDTO;
import com.example.springbootrest.model.entity.RoleEntity;
import com.example.springbootrest.repository.RoleRepository;
import com.example.springbootrest.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {

        RoleEntity roleEntity = new RoleEntity();
        BeanUtils.copyProperties(roleDTO, roleEntity);

        roleEntity = roleRepository.save(roleEntity);
        BeanUtils.copyProperties(roleEntity, roleDTO);

        return roleDTO;
    }
}

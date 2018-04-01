package com.netcracker.etalon.services.impl;

import com.netcracker.etalon.entities.RoleEntity;
import com.netcracker.etalon.repository.RoleRepository;
import com.netcracker.etalon.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void add(RoleEntity roleEntity) {
        roleRepository.save(roleEntity);
    }
}

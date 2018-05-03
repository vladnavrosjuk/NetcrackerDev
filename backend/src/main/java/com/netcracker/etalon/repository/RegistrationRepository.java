package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.RegistrationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.taglibs.authz.AccessControlListTag;

import java.util.List;

public interface RegistrationRepository extends CrudRepository<RegistrationEntity,Integer> {
    List<RegistrationEntity> findByRole (String name);
    RegistrationEntity findById(Integer id);
    void deleteById (Integer id);
}

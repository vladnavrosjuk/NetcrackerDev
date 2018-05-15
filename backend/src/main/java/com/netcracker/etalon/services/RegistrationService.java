package com.netcracker.etalon.services;

import com.netcracker.etalon.entities.RegistrationEntity;

import java.util.List;

public interface RegistrationService {
    void addRegistration(RegistrationEntity registrationEntity);
    List<RegistrationEntity> findByRole (String name);
    List<RegistrationEntity> findAll() ;
    RegistrationEntity findById(Integer id);
    void deleteById (Integer id);
}

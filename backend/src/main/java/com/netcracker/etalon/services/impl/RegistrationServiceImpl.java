package com.netcracker.etalon.services.impl;

import com.netcracker.etalon.entities.RegistrationEntity;
import com.netcracker.etalon.repository.RegistrationRepository;
import com.netcracker.etalon.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    RegistrationRepository registrationRepository;


    @Override
    public void addRegistration(RegistrationEntity registrationEntity) {
        registrationRepository.save(registrationEntity);
    }

    @Override
    public List<RegistrationEntity> findByRole(String name) {
        return registrationRepository.findByRole(name);
    }

    @Override
    public List<RegistrationEntity> findAll() {
        return (List<RegistrationEntity>) registrationRepository.findAll();
    }

    @Override
    public RegistrationEntity findById(Integer id) {
        return registrationRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        registrationRepository.deleteById(id);
    }
}

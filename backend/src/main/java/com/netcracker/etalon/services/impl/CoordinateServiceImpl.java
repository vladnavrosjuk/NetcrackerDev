package com.netcracker.etalon.services.impl;

import com.netcracker.etalon.entities.CoordinatEntity;
import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.repository.CoordinatrRepository;
import com.netcracker.etalon.repository.RegistrationRepository;
import com.netcracker.etalon.services.CoordinateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CoordinateServiceImpl implements CoordinateService {
    @Autowired
    CoordinatrRepository coordinatrRepository;
    @Override
    public void addCoordinate(CoordinatEntity coordinatEntity) {
        coordinatrRepository.save(coordinatEntity);


    }

    @Override
    public CoordinatEntity findByRequest(RequestEntity requestEntity) {
        return  coordinatrRepository.findByRequest(requestEntity);
    }
}

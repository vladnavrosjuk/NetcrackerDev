package com.netcracker.etalon.services.impl;

import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.repository.RequestRepository;
import com.netcracker.etalon.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class RequestServiceImpl  implements RequestService{
    @Autowired
    RequestRepository requestRepository;
    @Override
    public void addRequest(RequestEntity requestEntity) {
        requestRepository.save(requestEntity);


    }
}

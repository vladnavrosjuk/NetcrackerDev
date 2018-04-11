package com.netcracker.etalon.services.impl;

import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.repository.RequestRepository;
import com.netcracker.etalon.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RequestServiceImpl  implements RequestService{
    @Autowired
    RequestRepository requestRepository;
    @Override
    public void addRequest(RequestEntity requestEntity) {
        requestRepository.save(requestEntity);


    }
    public List<RequestEntity> find (){
        return (List<RequestEntity>) requestRepository.findAll();

    }

    @Override
    public RequestEntity findById(Integer id) {
        return requestRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        requestRepository.deleteById(id);
    }


}

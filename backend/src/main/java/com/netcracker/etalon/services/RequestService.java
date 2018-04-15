package com.netcracker.etalon.services;

import com.netcracker.etalon.entities.RequestEntity;

import java.util.List;


public interface RequestService {
    void addRequest(RequestEntity requestEntity);
    List<RequestEntity> find();
    RequestEntity findById(Integer id);
    void deleteById(Integer id);
    List<RequestEntity> requestAfterCurentDate();


}

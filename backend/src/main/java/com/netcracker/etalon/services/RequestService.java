package com.netcracker.etalon.services;

import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.entities.StudentEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface RequestService {
    void addRequest(RequestEntity requestEntity);
    List<RequestEntity> find();
    RequestEntity findById(Integer id);
    void deleteById(Integer id);
    void deleteByNamecompany(String name);
    List<RequestEntity> requestAfterCurentDate();
    List<RequestEntity> searchbyname(String score);



}

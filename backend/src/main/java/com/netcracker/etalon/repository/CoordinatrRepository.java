package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.CoordinatEntity;
import com.netcracker.etalon.entities.RequestEntity;
import org.springframework.data.repository.CrudRepository;

public interface CoordinatrRepository extends CrudRepository<CoordinatEntity, Integer> {
    CoordinatEntity findByRequest (RequestEntity requestEntity);
}

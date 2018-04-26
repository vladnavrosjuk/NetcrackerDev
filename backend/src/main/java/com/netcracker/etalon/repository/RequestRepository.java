package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.RequestEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestRepository extends CrudRepository<RequestEntity, Integer> {
    RequestEntity findById(Integer id);
    void deleteById(Integer id);
    void deleteByNamecompany(String name);
    @Query (value = "SELECT * FROM request WHERE request.datestart < curdate()", nativeQuery = true)
    List<RequestEntity> requestAfterCurentDate();

}

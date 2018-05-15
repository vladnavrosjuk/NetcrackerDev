package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.entities.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestRepository extends CrudRepository<RequestEntity, Integer> {
    RequestEntity findById(Integer id);
    void deleteById(Integer id);
    void deleteByNamecompany(String name);
    @Query (value = "SELECT * FROM request WHERE request.datestart < curdate()", nativeQuery = true)
    List<RequestEntity> requestAfterCurentDate();
    @Query (value = "SELECT * FROM request WHERE  request.namecompany LIKE :namestudena ", nativeQuery = true)
    List<RequestEntity> searchbyname(@Param("namestudena") String score);





}

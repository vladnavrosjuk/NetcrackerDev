package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.StudentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer>
{
        StudentEntity findByNamestud(String name);

        StudentEntity findById(Integer id);
      @Query (value = "SELECT * FROM student WHERE avscore > :score AND  spec_id = :specid ", nativeQuery = true)
        List<StudentEntity> selectfronscore(@Param("score") Double score, @Param("specid") Integer specid);
}

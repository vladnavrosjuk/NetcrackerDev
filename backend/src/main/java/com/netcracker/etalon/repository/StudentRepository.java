package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer>
{
        StudentEntity findByNamestud(String name);

}

package com.netcracker.etalon.services;

import com.netcracker.etalon.entities.StudentEntity;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentService {
    void addStudent(StudentEntity studentEntity);
    StudentEntity find(String name);
    StudentEntity findById(Integer id);
    List<StudentEntity> findall();
    List<StudentEntity> findbyquantityandfacultet(Double score, Integer idspeciality);
    void deleteById (Integer id);
    List<StudentEntity> searchbyname(String score);

    Integer maxId();

}

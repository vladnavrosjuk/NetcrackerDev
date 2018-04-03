package com.netcracker.etalon.services;

import com.netcracker.etalon.entities.StudentEntity;

public interface StudentService {
    void addStudent(StudentEntity studentEntity);
    StudentEntity find(String name);

}

package com.netcracker.etalon.services.impl;

import com.netcracker.etalon.entities.StudentEntity;
import com.netcracker.etalon.repository.StudentRepository;
import com.netcracker.etalon.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public void addStudent(StudentEntity studentEntity) {
        studentRepository.save(studentEntity);

    }

    @Override
    public StudentEntity find(String name) {
        return studentRepository.findByNamestud(name);
    }
}

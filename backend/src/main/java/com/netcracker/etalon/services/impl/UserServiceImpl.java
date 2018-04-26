package com.netcracker.etalon.services.impl;

import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.entities.StudentEntity;
import com.netcracker.etalon.entities.UserEntity;
import com.netcracker.etalon.repository.UserRepository;
import com.netcracker.etalon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void add(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> find(String login) {
        return userRepository.findByLogin(login);
    }


    @Override
    public List<UserEntity> findall() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public UserEntity findByStudentEntity(StudentEntity studentEntity) {
        return userRepository.findByStudentEntity(studentEntity);
    }





    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity findById(Integer id) {
        return userRepository.findById(id);
    }

}

package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.RequestEntity;
import com.netcracker.etalon.entities.StudentEntity;
import com.netcracker.etalon.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    List<UserEntity> findByLogin (String name);
   UserEntity findByStudentEntity (StudentEntity studentEntity);

   void deleteById(Integer id);
   void deleteByLogin (String login);
   UserEntity findById(Integer id);


}

package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    List<UserEntity> findByLogin (String name);

}

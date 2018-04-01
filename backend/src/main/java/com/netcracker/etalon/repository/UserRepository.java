package com.netcracker.etalon.repository;

import com.netcracker.etalon.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    UserEntity findByLogin (String name);
}

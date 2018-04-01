package com.netcracker.etalon.services;

import com.netcracker.etalon.entities.UserEntity;

public interface UserService {
    void add(UserEntity userEntity);
    UserEntity find(String login);
}

package com.netcracker.etalon.services;

import com.netcracker.etalon.entities.UserEntity;
import org.springframework.security.taglibs.authz.AccessControlListTag;

import java.util.List;

public interface UserService {
    void add(UserEntity userEntity);
    List<UserEntity> find(String login);
    List<UserEntity> findall();
}

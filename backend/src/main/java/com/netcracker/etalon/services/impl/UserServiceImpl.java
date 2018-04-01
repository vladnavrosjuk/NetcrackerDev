package com.netcracker.etalon.services.impl;

import com.netcracker.etalon.entities.UserEntity;
import com.netcracker.etalon.repository.UserRepository;
import com.netcracker.etalon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public UserEntity find(String login) {
        return userRepository.findByLogin(login);
    }

}

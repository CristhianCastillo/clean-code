package com.cleancode.domain.service;

import com.cleancode.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserEntity> getAll();

    UserEntity getById(Long id);

    UserEntity save(UserEntity userEntity);

    UserEntity update(UserEntity userEntity);

    void delete(UserEntity userEntity);

}

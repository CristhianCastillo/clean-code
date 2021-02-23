package com.cleancode.domain.service;

import com.cleancode.persistence.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    // TODO: 9. Elija una sola palabra por concepto y úsela de forma coherente en todo el código fuente.
    List<UserEntity> getAll();

    UserEntity findById(Long id);

    UserEntity saveUser(UserEntity userEntity);

    UserEntity userUpdate(UserEntity userEntity);

    void delete(UserEntity userEntity);

}

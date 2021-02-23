package com.cleancode.domain.service.imp;

import com.cleancode.constant.StatusConstant;
import com.cleancode.persistence.crud.UserRepository;
import com.cleancode.domain.service.UserService;
import com.cleancode.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserEntity> getAll() {
        return this.userRepository.findAll();
    }

    @Override
    public UserEntity getById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id: " + id + " not found"));
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    @Override
    public void delete(UserEntity userEntity) {
        userEntity.setStatus(StatusConstant.DISABLED_STATUS);
        this.userRepository.save(userEntity);
    }
}

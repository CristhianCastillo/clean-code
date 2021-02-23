package com.cleancode.domain.manage;

import com.cleancode.constant.StatusConstant;
import com.cleancode.domain.dto.request.UserRequest;
import com.cleancode.domain.dto.response.UserResponse;
import com.cleancode.domain.service.UserService;
import com.cleancode.persistence.entity.UserEntity;
import com.cleancode.persistence.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ManageUserServiceImp implements ManageUserService {

    private final UserMapper mapperService;
    private final UserService userService;

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserResponse> userResponseList = new ArrayList<>();
        this.userService.getAll().forEach(user -> userResponseList.add(this.mapperService.convertEntityToResponse(user)));
        return userResponseList;
    }

    @Override
    public UserResponse getUserById(Long userId) {
        return this.mapperService.convertEntityToResponse(this.userService.getById(userId));
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity = this.mapperService.convertRequestToEntity(userRequest);
        userEntity.setStatus(StatusConstant.ENABLED_STATUS);
        userEntity = this.userService.save(userEntity);
        return this.mapperService.convertEntityToResponse(userEntity);
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        UserEntity user = this.userService.getById(userRequest.getId());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setCareer(userRequest.getCareer());
        return this.mapperService.convertEntityToResponse(this.userService.save(user));
    }

    @Override
    public void deleteUser(Long userId) {
        UserEntity user = this.userService.getById(userId);
        user.setStatus(StatusConstant.DISABLED_STATUS);
        this.userService.save(user);
    }
}

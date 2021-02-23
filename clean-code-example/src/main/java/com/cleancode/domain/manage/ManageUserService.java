package com.cleancode.domain.manage;

import com.cleancode.domain.dto.request.UserRequest;
import com.cleancode.domain.dto.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManageUserService {

    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long userId);

    UserResponse createUser(UserRequest userRequest);

    UserResponse updateUser(UserRequest userRequest);

    void deleteUser(Long userId);
}

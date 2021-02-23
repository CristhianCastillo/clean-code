package com.cleancode.domain.manage;

import com.cleancode.constant.StatusConstant;
import com.cleancode.domain.dto.request.UserRequest;
import com.cleancode.domain.dto.response.UserResponse;
import com.cleancode.domain.service.UserService;
import com.cleancode.persistence.entity.UserEntity;
import com.cleancode.persistence.mapper.TransformUser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ManageUserServiceImp implements ManageUserService {

    private final TransformUser mapperService;
    private final UserService userService;

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserResponse> userResponses = new ArrayList<>(); // TODO: 9. Evite usar una palabra con un significado aceptado para otra cosa.
        this.userService.getAll().forEach(user -> userResponses.add(this.mapperService.convertEntityToResponse(user)));
        return userResponses;
    }

    @Override
    public UserResponse getUserById(Long userId) {
        return this.mapperService.convertEntityToResponse(this.userService.findById(userId));
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity oneUser = this.mapperService.convertRequestToEntity(userRequest); // TODO: 10. Evite usar detalles de implementación
        oneUser.setStatus(StatusConstant.ENABLED_STATUS);
        oneUser = this.userService.saveUser(oneUser);
        return this.mapperService.convertEntityToResponse(oneUser);
    }

    // TODO: 12. Evite el uso de letras confusas para los nombres
    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        UserEntity u = this.userService.findById(userRequest.getId());
        u.setFirstName(userRequest.getFirstName());
        u.setLastName(userRequest.getLastName());
        u.setCareer(userRequest.getCareer());
        return this.mapperService.convertEntityToResponse(this.userService.saveUser(u));
    }

    @Override
    public void deleteUser(Long userId) {
        UserEntity user = this.userService.findById(userId);
        user.setStatus(StatusConstant.DISABLED_STATUS);
        this.userService.saveUser(user);
    }
}

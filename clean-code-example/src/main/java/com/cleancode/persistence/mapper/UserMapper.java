package com.cleancode.persistence.mapper;

import com.cleancode.domain.dto.request.UserRequest;
import com.cleancode.domain.dto.response.UserResponse;
import com.cleancode.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserMapper {

    private final ModelMapper modelMapper;

    public UserEntity convertRequestToEntity(UserRequest userRequest) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(userRequest, UserEntity.class);
    }

    public UserResponse convertEntityToResponse(UserEntity userEntity) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(userEntity, UserResponse.class);
    }
}

package com.cleancode.persistence.mapper;

import com.cleancode.domain.dto.request.CourseRequest;
import com.cleancode.domain.dto.response.CourseResponse;
import com.cleancode.persistence.entity.CourseEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseMapper {

    private final ModelMapper modelMapper;

    public CourseEntity convertRequestToEntity(CourseRequest courseRequest) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(courseRequest, CourseEntity.class);
    }

    public CourseResponse convertEntityToResponse(CourseEntity courseEntity) {
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(courseEntity, CourseResponse.class);
    }

}

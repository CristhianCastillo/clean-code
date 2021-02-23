package com.cleancode.domain.service;

import com.cleancode.persistence.entity.CourseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<CourseEntity> getAll();

    CourseEntity getById(Long id);

    CourseEntity save(CourseEntity courseEntity);

    CourseEntity update(CourseEntity courseEntity);

    void delete(CourseEntity courseEntity);

}

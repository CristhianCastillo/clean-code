package com.cleancode.domain.manage;

import com.cleancode.constant.StatusConstant;
import com.cleancode.domain.dto.request.CourseRequest;
import com.cleancode.domain.dto.response.CourseResponse;
import com.cleancode.domain.service.CourseService;
import com.cleancode.persistence.entity.CourseEntity;
import com.cleancode.persistence.mapper.CourseMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ManageCourseServiceImp implements ManageCourseService {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseResponse> getAllCourses() {
        List<CourseResponse> courseResponseList = new ArrayList<>();
        this.courseService.getAll().forEach(user -> courseResponseList.add(this.courseMapper.convertEntityToResponse(user)));
        return courseResponseList;
    }

    @Override
    public CourseResponse getCourseById(Long courseId) {
        return this.courseMapper.convertEntityToResponse(this.courseService.getById(courseId));
    }

    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) {
        CourseEntity courseEntity = this.courseMapper.convertRequestToEntity(courseRequest);
        courseEntity.setStatus(StatusConstant.ENABLED_STATUS);
        courseEntity = this.courseService.save(courseEntity);
        return this.courseMapper.convertEntityToResponse(courseEntity);
    }

    @Override
    public CourseResponse updateCourse(CourseRequest courseRequest) {
        CourseEntity course = this.courseService.getById(courseRequest.getId());
        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        return this.courseMapper.convertEntityToResponse(this.courseService.save(course));
    }

    @Override
    public void deleteCourse(Long courseId) {
        CourseEntity course = this.courseService.getById(courseId);
        course.setStatus(StatusConstant.DISABLED_STATUS);
        this.courseService.save(course);
    }
}

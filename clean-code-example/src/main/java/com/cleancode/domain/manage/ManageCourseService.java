package com.cleancode.domain.manage;

import com.cleancode.domain.dto.request.CourseRequest;
import com.cleancode.domain.dto.response.CourseResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManageCourseService {

    List<CourseResponse> getAllCourses();

    CourseResponse getCourseById(Long courseId);

    CourseResponse createCourse(CourseRequest courseRequest);

    CourseResponse updateCourse(CourseRequest courseRequest);

    void deleteCourse(Long courseId);

}

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

    private final CourseService courServ;
    private final CourseMapper courseMapper;

    // TODO: 1.Utilice nombres que revelen la intención
    @Override
    public List<CourseResponse> gAllCour() {
        List<CourseResponse> jkl = new ArrayList<>();
        this.courServ.getAll().forEach(user -> jkl.add(this.courseMapper.convertEntityToResponse(user)));
        return jkl;
    }

    @Override
    public CourseResponse getCourseById(Long courseId) {
        return this.courseMapper.convertEntityToResponse(this.courServ.getById(courseId));
    }

    // TODO: 16. Menos número de argumentos (≤3) es mejor.
    @Override
    public CourseResponse createCourse(Long id, String name, String description) {
        CourseRequest courseRequest = new CourseRequest(id, name, description);
        CourseEntity courseEntity = this.courseMapper.convertRequestToEntity(courseRequest);
        courseEntity.setStatus(StatusConstant.ENABLED_STATUS);
        courseEntity = this.courServ.save(courseEntity);
        return this.courseMapper.convertEntityToResponse(courseEntity);
    }

    @Override
    public CourseResponse updateCourse(CourseRequest courseRequest) {
        CourseEntity course = this.courServ.getById(courseRequest.getId());
        String strCourseName = courseRequest.getName(); // TODO: 13. No codifique detalles adicionales en los nombres.
        course.setName(strCourseName);
        course.setDescription(courseRequest.getDescription());
        return this.courseMapper.convertEntityToResponse(this.courServ.save(course));
    }

    @Override
    public void deleteCourse(Long courseId) {
        CourseEntity courseInfo = this.courServ.getById(courseId); // TODO: 14. Evite los prefijos o sufijos sin sentido.
        courseInfo.setStatus(StatusConstant.DISABLED_STATUS);
        this.courServ.save(courseInfo);
    }

    // TODO: 21. Es mejor tener muchas funciones que pasar un código a una función para seleccionar un comportamiento.
    private void changeCourseStatus(String codeStatus, CourseEntity courseEntity) {
        switch (codeStatus) {
            case "01":
                courseEntity.setStatus(StatusConstant.ENABLED_STATUS);
            case "02":
                courseEntity.setStatus(StatusConstant.FINALIZED_STATUS);
            default:
                courseEntity.setStatus(StatusConstant.DISABLED_STATUS);
        }
    }
}

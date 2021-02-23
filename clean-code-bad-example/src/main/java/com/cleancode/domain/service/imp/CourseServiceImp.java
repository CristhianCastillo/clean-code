package com.cleancode.domain.service.imp;

import com.cleancode.constant.StatusConstant;
import com.cleancode.domain.service.CourseService;
import com.cleancode.persistence.crud.CourseRepository;
import com.cleancode.persistence.entity.CourseEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseEntity> getAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public CourseEntity getById(Long id) {
        return this.courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course with id: " + id + " not found."));
    }

    @Override
    public CourseEntity save(CourseEntity courseEntity) {
        return this.courseRepository.save(courseEntity);
    }

    @Override
    public CourseEntity update(CourseEntity courseEntity) {
        return this.courseRepository.save(courseEntity);
    }

    // TODO: 6. Utilice comentarios para revelar información adicional como lógica empresarial compleja, comportamientos, suposiciones, sugerencias futuras
    @Override
    public void delete(CourseEntity courseEntity) {
        courseEntity.setStatus(StatusConstant.DISABLED_STATUS); // Can be a Enum.
        this.courseRepository.save(courseEntity);
    }
}

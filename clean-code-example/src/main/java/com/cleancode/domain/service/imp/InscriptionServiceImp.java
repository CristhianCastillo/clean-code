package com.cleancode.domain.service.imp;

import com.cleancode.constant.StatusConstant;
import com.cleancode.domain.service.InscriptionService;
import com.cleancode.persistence.crud.InscriptionRepository;
import com.cleancode.persistence.entity.InscriptionEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class InscriptionServiceImp implements InscriptionService {

    private final InscriptionRepository inscriptionRepository;

    @Override
    public List<InscriptionEntity> getByUserId(Long userId) {
        return this.inscriptionRepository.findByUserId(userId);
    }

    @Override
    public InscriptionEntity getByUserIdAndCourseId(Long userId, Long courseId) {
        return this.inscriptionRepository.findByUserIdAndCourseId(userId, courseId);
    }

    @Override
    public InscriptionEntity save(InscriptionEntity inscriptionEntity) {
        return this.inscriptionRepository.save(inscriptionEntity);
    }

    @Override
    public InscriptionEntity update(InscriptionEntity inscriptionEntity) {
        return this.inscriptionRepository.save(inscriptionEntity);
    }

    @Override
    public void delete(InscriptionEntity inscriptionEntity) {
        inscriptionEntity.setStatus(StatusConstant.DISABLED_STATUS);
        this.inscriptionRepository.save(inscriptionEntity);
    }
}

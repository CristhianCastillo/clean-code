package com.cleancode.domain.manage;

import com.cleancode.constant.StatusConstant;
import com.cleancode.domain.dto.request.InscriptionRequest;
import com.cleancode.domain.dto.request.ScoreInscriptionRequest;
import com.cleancode.domain.service.CourseService;
import com.cleancode.domain.service.InscriptionService;
import com.cleancode.domain.service.UserService;
import com.cleancode.persistence.entity.CourseEntity;
import com.cleancode.persistence.entity.InscriptionEntity;
import com.cleancode.persistence.entity.UserEntity;
import com.cleancode.persistence.entity.id.InscriptionId;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ManageInscriptionServiceImp implements ManageInscriptionService {

    private final UserService userService;
    private final CourseService courseService;
    private final InscriptionService insService;

    // TODO: 2. Haz distinciones significativas.
    @Override
    public void createInscription(InscriptionRequest inscriptionRequest) {

        // TODO: 20. Utilice try/ en catchlugar de condiciones si es posible. (Pedir perdón es más fácil que pedir permiso.)
        UserEntity user1 = this.userService.findById(inscriptionRequest.getUserId());
        CourseEntity course1 = this.courseService.getById(inscriptionRequest.getCourseId());
        InscriptionEntity inscription = this.insService.getByUserIdAndCourseId(inscriptionRequest.getUserId(), inscriptionRequest.getCourseId());
        if (inscription != null) {
            throw new RuntimeException("Inscription Already Exists!");
        }
        inscription = new InscriptionEntity();
        InscriptionId inscriptionId = new InscriptionId(user1, course1);
        inscription.setInscriptionId(inscriptionId);
        inscription.setScore(0L);
        inscription.setStatus(StatusConstant.ENABLED_STATUS);
        this.insService.save(inscription);
    }

    // TODO: 3. Elija nombres descriptivos y sin ambigüedades.
    @Override
    public void updScrIns(ScoreInscriptionRequest scoreInscriptionRequest) {
        // TODO: 18. Una función debe hacer solo una cosa (mantenerla atómica)
        InscriptionEntity ins = this.insService.getByUserIdAndCourseId(scoreInscriptionRequest.getUserId(), scoreInscriptionRequest.getCourseId());
        if (!ins.getStatus().equals(StatusConstant.ENABLED_STATUS)) {
            throw new RuntimeException("Inscription is not Enabled!");
        }
        ins.setScore(scoreInscriptionRequest.getScore());
        this.insService.update(ins);
    }

    @Override
    public void finishInscription(InscriptionRequest inscriptionRequest) {
        // TODO: 18. Una función debe hacer solo una cosa (mantenerla atómica)
        InscriptionEntity inscription = this.insService.getByUserIdAndCourseId(inscriptionRequest.getUserId(), inscriptionRequest.getCourseId());
        if (!inscription.getStatus().equals(StatusConstant.ENABLED_STATUS)) {
            throw new RuntimeException("Inscription is not Enabled!");
        }
        if (inscription.getScore() < 3L) {
            throw new RuntimeException("The score is not valid to finish"); // TODO 19. El manejo de errores es una cosa. Mantenga las funciones que solo hacen eso.
        }
        inscription.setStatus(StatusConstant.FINALIZED_STATUS);
        this.insService.update(inscription);
    }

    // TODO: 20. Evite las estructuras de control anidadas.
    private List<InscriptionEntity> getUserGoodInscriptions(Long userId) {
        List<InscriptionEntity> list = this.insService.getByUserId(userId);
        List<InscriptionEntity> goodList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            InscriptionEntity temp = list.get(i);
            if (temp.getStatus().equals(StatusConstant.ENABLED_STATUS)) {
                goodList.add(temp);
            }
        }
        return goodList;
    }
}

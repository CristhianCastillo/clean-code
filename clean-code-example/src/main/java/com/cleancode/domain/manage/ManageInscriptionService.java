package com.cleancode.domain.manage;

import com.cleancode.domain.dto.request.InscriptionRequest;
import com.cleancode.domain.dto.request.ScoreInscriptionRequest;
import org.springframework.stereotype.Service;

@Service
public interface ManageInscriptionService {

    void createInscription(InscriptionRequest inscriptionRequest);

    void updateScoreInscription(ScoreInscriptionRequest scoreInscriptionRequest);

    void finishInscription(InscriptionRequest inscriptionRequest);

}
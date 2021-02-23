package com.cleancode.domain.manage;

import com.cleancode.domain.dto.request.InscriptionRequest;
import com.cleancode.domain.dto.request.ScoreInscriptionRequest;
import org.springframework.stereotype.Service;

@Service
public interface ManageInscriptionService {

    void createInscription(InscriptionRequest inscriptionRequest);

    // TODO: 4. Utilice nombres pronunciables
    void updScrIns(ScoreInscriptionRequest scoreInscriptionRequest);

    void finishInscription(InscriptionRequest inscriptionRequest);

}
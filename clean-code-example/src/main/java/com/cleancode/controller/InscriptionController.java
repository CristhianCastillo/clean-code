package com.cleancode.controller;

import com.cleancode.domain.dto.request.InscriptionRequest;
import com.cleancode.domain.dto.request.ScoreInscriptionRequest;
import com.cleancode.domain.dto.response.ResponseDto;
import com.cleancode.domain.manage.ManageInscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/inscriptions")
@AllArgsConstructor
public class InscriptionController {

    private final ManageInscriptionService manageInscriptionService;

    @PostMapping
    public ResponseEntity<ResponseDto<String>> createInscription(@RequestBody @Valid InscriptionRequest inscriptionRequest) {
        this.manageInscriptionService.createInscription(inscriptionRequest);
        return new ResponseEntity<>(ResponseDto.success("Inscription created successfully"), HttpStatus.CREATED);
    }

    @PostMapping("/score")
    public ResponseEntity<ResponseDto<String>> updateScoreInscription(@RequestBody @Valid ScoreInscriptionRequest scoreInscriptionRequest) {
        this.manageInscriptionService.updateScoreInscription(scoreInscriptionRequest);
        return new ResponseEntity<>(ResponseDto.success("Inscription score updated successfully"), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseDto<String>> updateInscription(@RequestBody @Valid InscriptionRequest inscriptionRequest) {
        this.manageInscriptionService.finishInscription(inscriptionRequest);
        return new ResponseEntity<>(ResponseDto.success("Inscription finished successfully"), HttpStatus.OK);
    }

}

package com.cleancode.persistence.crud;

import com.cleancode.persistence.entity.InscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<InscriptionEntity, Long> {

    @Query(value = "SELECT i FROM InscriptionEntity AS i " +
            "INNER JOIN i.inscriptionId.userEntity AS u " +
            "WHERE i.status <> 'disabled' " +
            "AND u.id = :userId ")
    List<InscriptionEntity> findByUserId(Long userId);

    // TODO: 8. Use verbos / frases verbales para funciones.
    @Query(value = "SELECT i FROM InscriptionEntity AS i " +
            "INNER JOIN i.inscriptionId.courseEntity AS co " +
            "INNER JOIN i.inscriptionId.userEntity as ua " +
            "WHERE co.id= :courseId AND ua.id = :userId ")
    InscriptionEntity userIdAndCourseId(Long userId, Long courseId);

}

package com.cleancode.persistence.entity;

import com.cleancode.persistence.entity.id.InscriptionId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "inscription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InscriptionEntity extends BaseEntity implements Serializable {

    @EmbeddedId
    private InscriptionId inscriptionId;

    @Column(name = "score")
    private Long score;

    // TODO: 23. Mantenga las funciones booleanas en un tono positivo.
    private boolean isInactivate() {
        return false;
    }

}

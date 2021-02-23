package com.cleancode.persistence.entity.id;

import com.cleancode.persistence.entity.BaseEntity;
import com.cleancode.persistence.entity.CourseEntity;
import com.cleancode.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Component
public class InscriptionId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id")
    private CourseEntity courseEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscriptionId that = (InscriptionId) o;
        return userEntity.equals(that.userEntity) &&
                courseEntity.equals(that.courseEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEntity, courseEntity);
    }

}

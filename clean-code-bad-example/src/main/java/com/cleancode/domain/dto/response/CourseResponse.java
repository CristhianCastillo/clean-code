package com.cleancode.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseResponse implements Serializable {

    private Long id;
    private String name;
    private String description;


    // TODO: 22: Una función puede ser un comando o una consulta, pero no ambos.
    public boolean setDescription(String description) {
        this.description = description;
        return true;
    }
}

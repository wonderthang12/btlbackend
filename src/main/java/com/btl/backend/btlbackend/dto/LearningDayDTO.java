package com.btl.backend.btlbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class LearningDayDTO extends BaseDTO {

    private Set<SubjectDTO> subjects = new HashSet<>();

    private Integer stage;

    private Integer semester;

    private Long teacherId;

    private String createdName;

    private String updatedName;
}

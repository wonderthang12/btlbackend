package com.btl.backend.btlbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class SubjectDTO extends BaseDTO {

    private String name;

    private String methodOfExamination;

    private ZonedDateTime timeOfExamination;

    private Set<LearningDayDTO> learningDays = new HashSet<>();

    private Set<ScheduleDTO> schedules = new HashSet<>();

    private Set<PoetryDTO> poetries = new HashSet<>();

    private String subjectCode;

    private String createdName;

    private String updatedName;
}

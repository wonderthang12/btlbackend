package com.btl.backend.btlbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class ScheduleDTO extends BaseDTO {

    private Set<StudentDTO> students = new HashSet<>();

    private Set<FacultyDTO> faculties = new HashSet<>();

    private Long studentId;

    private Set<SubjectDTO> subjects = new HashSet<>();

    private String createdName;

    private String updatedName;
}

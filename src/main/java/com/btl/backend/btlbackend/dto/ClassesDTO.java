package com.btl.backend.btlbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class ClassesDTO extends BaseDTO {

    private String name;

    private Set<FacultyDTO> faculties = new HashSet<>();

    private Set<StudentDTO> students = new HashSet<>();

    private String classesCode;

    private String createdName;

    private String updatedName;

}

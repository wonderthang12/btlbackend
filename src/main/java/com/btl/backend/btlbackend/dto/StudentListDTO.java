package com.btl.backend.btlbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class StudentListDTO extends BaseDTO {

    private String identificationNumber;

    private Set<StudentDTO> students = new HashSet<>();

    private Set<PoetryDTO> poetries = new HashSet<>();

    private String createdName;

    private String updatedName;


}

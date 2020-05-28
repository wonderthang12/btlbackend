package com.btl.backend.btlbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class PoetryDTO extends BaseDTO {

    private ZonedDateTime examDate;

    private Integer time;

    private String subjectName;

    private Long subjectId;

    private Set<StudentListDTO> studentLists = new HashSet<>();

    private Long roomId;

    private Set<TeacherDTO> teachers = new HashSet<>();

    private String poetryCode;

    private String createdName;

    private String updatedName;


}

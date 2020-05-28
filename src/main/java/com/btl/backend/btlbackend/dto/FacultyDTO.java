package com.btl.backend.btlbackend.dto;

import com.btl.backend.btlbackend.dao.model.FacultyEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class FacultyDTO extends BaseDTO {
    private String name;

    private Set<ScheduleDTO> schedules = new HashSet<>();

    private Long classesId;

    private String facultyCode;

    private String createdName;

    private String updatedName;
}

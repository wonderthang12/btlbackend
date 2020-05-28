package com.btl.backend.btlbackend.dto;

import com.btl.backend.btlbackend.dao.model.StudentListEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class StudentDTO extends BaseDTO {

    private String name;

    private String address;

    private String createdName;

    private String updatedName;

    private Long studentListId;

    private Set<ScheduleDTO> schedules = new HashSet<>();

    private Long classesId;

    private Long userId;

    private String studentCode;
}

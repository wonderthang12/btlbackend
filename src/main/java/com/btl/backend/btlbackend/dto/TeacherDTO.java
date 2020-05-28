package com.btl.backend.btlbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TeacherDTO extends BaseDTO {

    private String name;

    private String address;

    private Long poetryId;

    private Long learningDayId;

    private Long userId;

    private String teacherCode;

    private String createdName;

    private String updatedName;
}

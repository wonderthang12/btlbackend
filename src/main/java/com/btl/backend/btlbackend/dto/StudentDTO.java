package com.btl.backend.btlbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class StudentDTO extends BaseDTO {

    private String name;

    private String address;

}

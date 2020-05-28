package com.btl.backend.btlbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RoomDTO extends BaseDTO {

    private Integer seats;

    private String name;

    private Integer status;

    private Long poetryId;

    private String roomCode;

    private String createdName;

    private String updatedName;
}

package com.btl.backend.btlbackend.dto;

import com.btl.backend.btlbackend.enums.BlockEnum;
import com.btl.backend.btlbackend.enums.GenderEnum;
import com.btl.backend.btlbackend.enums.UserTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class UserDTO extends BaseDTO {

    private String name;

    private String email;

    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private GenderEnum gender;

    private String avatar;

    private BlockEnum block;

    private UserTypeEnum userType;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String salt;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String newPassword;

    private Long studentId;

    private Long teacherId;

    private String userCode;

    private String createdName;

    private String updatedName;

}

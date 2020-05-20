package com.btl.backend.btlbackend.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public interface IEnum {
    @JsonValue
    Integer getValue();
}

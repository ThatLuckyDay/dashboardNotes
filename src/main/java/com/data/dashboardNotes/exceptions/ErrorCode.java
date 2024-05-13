package com.data.dashboardNotes.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum ErrorCode {
    FORBIDDEN_SYMBOLS("There are forbidden characters"),
    EMPTY_FIELD("Required field %s"),
    SERVER_ERROR("undefined", "Server Error"),
    UNDEFINED_ERROR("undefined", "%s"),
    CODE_EXIST("Code already exists by Device with id = %s"),
    WRONG_CODE_FORMAT("Обозначение должно быть вида: ххх.ххх.ххх"),
    CODE_NOT_EXIST("Device with Code = %s not exist"),
    DEVICE_NOT_FOUND("Device with id = %s not found");

    @Setter
    private String field;
    @Setter
    private String message;

    ErrorCode(String message) {
        this.message = message;
    }

    ErrorCode(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public void formatMessage(String... str) {
        this.message = String.format(this.getMessage(), (Object[]) str);
    }
}

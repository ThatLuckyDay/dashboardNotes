package com.data.dashboardNotes.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionCustom extends RuntimeException {
    private ErrorCode errorCode;
    private List<String> params;

    public ExceptionCustom(ErrorCode errorCode, String... params) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.params = Arrays.asList(params);
    }

}

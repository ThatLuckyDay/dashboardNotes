package com.data.dashboardNotes.filter;

import com.data.dashboardNotes.exceptions.ErrorCode;
import com.data.dashboardNotes.exceptions.ExceptionCustom;
import com.data.dashboardNotes.model.Device;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class DeviceFilter {
    public final int CODE_LENGTH = 11;

    // xxx.xxx.xxx
    public final String CODE_PATTERN = "^\\w{3}\\.\\w{3}\\.\\w{3}$";

    public void checkFullName(Device device) {
        String code = device.getCode();
        String name = device.getType();
        if (code == null || !code.matches(CODE_PATTERN)) {
            throw new ExceptionCustom(ErrorCode.WRONG_CODE_FORMAT);
        }
        if (name.isBlank()) {
            ErrorCode error = ErrorCode.EMPTY_FIELD;
            error.formatMessage("Наименование");
            throw new ExceptionCustom(error);
        }
    }
}

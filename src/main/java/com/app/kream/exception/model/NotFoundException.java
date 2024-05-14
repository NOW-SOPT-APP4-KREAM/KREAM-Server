package com.app.kream.exception.model;

import com.app.kream.exception.ErrorMessage;

public class NotFoundException extends BusinessException {
    public NotFoundException(final ErrorMessage errorMessage) {
        super(errorMessage);
    }
}

package org.test.wsd.testcommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GenericValidationException extends RuntimeException {
    private final String errorMessageCode;
    private final String fieldName;
    private final String fieldValue;

    public GenericValidationException(String errorMessageCode, String fieldName, String fieldValue) {
        super(String.format(errorMessageCode, fieldValue, fieldName));
        this.errorMessageCode = errorMessageCode;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}

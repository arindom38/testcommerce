package org.test.wsd.testcommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class GenericNotFoundException extends RuntimeException {
    private final String errorMessageCode;
    private final String entityId;

    public GenericNotFoundException(String errorMessageCode, String entityId) {
        super(String.format(errorMessageCode, entityId));
        this.errorMessageCode = errorMessageCode;
        this.entityId = entityId;
    }
}

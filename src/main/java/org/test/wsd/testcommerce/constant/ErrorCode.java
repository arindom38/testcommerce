package org.test.wsd.testcommerce.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorCode {
    public static final String ENTITY_NOT_FOUND_WITH_ID = "Entity not found with id: %s";
    public static final String ENTITY_NOT_FOUND_WITH_NAME = "Entity not found with name: %s";
    public static final String ENTITY_ALREADY_EXISTS_WITH_ID = "Entity with id: %s already exists";
    public static final String ENTITY_ALREADY_EXISTS_WITH_NAME = "Entity with name: %s already exists";
    public static final String INVALID_VALUE_FOR_FIELD = "Invalid value %s for field %s";
    public static final String INVALID_VALUE_FOR_REQUEST_PARAMS = "Invalid value for request params";
    public static final String FILED_SHOULD_NOT_BE_NULL = "Field should not be null";
}

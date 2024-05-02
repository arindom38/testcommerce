package org.test.wsd.testcommerce.handler;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.test.wsd.testcommerce.dto.ExceptionResponseDto;
import org.test.wsd.testcommerce.exception.GenericNotFoundException;
import org.test.wsd.testcommerce.exception.GenericValidationException;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

    @ExceptionHandler(GenericNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleEntityNotFoundException(GenericNotFoundException e) {
        ExceptionResponseDto response = ExceptionResponseDto
                .builder()
                .status(HttpStatus.NOT_FOUND)
                .message(String.format(e.getErrorMessageCode(), e.getEntityId()))
                .timeStamp(LocalDateTime.now())
                .build();

        return buildResponseEntity(HttpStatus.NOT_FOUND, response);
    }

    @ExceptionHandler(GenericValidationException.class)
    public ResponseEntity<ExceptionResponseDto> handleGenericFieldValidationException(GenericValidationException e) {
        ExceptionResponseDto response = ExceptionResponseDto
                .builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(String.format(e.getErrorMessageCode(), e.getFieldValue(), e.getFieldName()))
                .timeStamp(LocalDateTime.now())
                .build();

        return buildResponseEntity(HttpStatus.BAD_REQUEST, response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionResponseDto> handleConstrainValidationException(ConstraintViolationException e) {
        ExceptionResponseDto response = ExceptionResponseDto
                .builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(e.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();

        return buildResponseEntity(HttpStatus.BAD_REQUEST, response);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponseDto> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        ExceptionResponseDto response = ExceptionResponseDto
                .builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(e.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();

        return buildResponseEntity(HttpStatus.BAD_REQUEST, response);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionResponseDto> handleMissingRequestParamValidationException(MissingServletRequestParameterException e) {
        ExceptionResponseDto response = ExceptionResponseDto
                .builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(e.getMessage())
                .timeStamp(LocalDateTime.now())
                .build();

        return buildResponseEntity(HttpStatus.BAD_REQUEST, response);
    }

    private <T> ResponseEntity<T> buildResponseEntity(HttpStatus responseStatus, T body) {
        return ResponseEntity.status(responseStatus)
                .header(MediaType.APPLICATION_JSON_VALUE)
                .header("Content-Type", "application/json;charset=utf-8")
                .body(body);
    }
}

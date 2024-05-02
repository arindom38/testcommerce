package org.test.wsd.testcommerce.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@Builder
public class ExceptionResponseDto implements Serializable {
    private HttpStatus status;
    private String message;
    private String fieldName;
    private LocalDateTime timeStamp;
}

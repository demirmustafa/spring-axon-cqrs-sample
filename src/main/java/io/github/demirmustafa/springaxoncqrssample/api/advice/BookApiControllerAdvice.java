package io.github.demirmustafa.springaxoncqrssample.api.advice;

import io.github.demirmustafa.springaxoncqrssample.api.BookApi;
import io.github.demirmustafa.springaxoncqrssample.exception.BusinessException;
import io.github.demirmustafa.springaxoncqrssample.exception.faultcode.BusinessFaultCode;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@Slf4j
@RestControllerAdvice(annotations = {BookApi.class})
@RequiredArgsConstructor
public class BookApiControllerAdvice {

    private final MessageSource messageSource;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handle(BusinessException e) {
        log.error("BookApiControllerAdvice handles BusinessException", e);
        final BusinessFaultCode faultCode = e.getFaultCode();
        ErrorResponse response = anErrorResponse(faultCode.getStatus(), messageSource.getMessage(faultCode.getCode(), null, Locale.getDefault()));
        return new ResponseEntity<>(response, HttpStatus.valueOf(faultCode.getStatus()));
    }

    private ErrorResponse anErrorResponse(Integer status, String message) {
        return ErrorResponse.builder()
                .status(status)
                .message(message)
                .build();
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class ErrorResponse {

        private Integer status;
        private String message;

    }
}

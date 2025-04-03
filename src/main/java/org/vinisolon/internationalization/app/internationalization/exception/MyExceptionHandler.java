package org.vinisolon.internationalization.app.internationalization.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.vinisolon.internationalization.app.internationalization.exception.MyExceptionResponse.buildExceptionResponse;
import static org.vinisolon.internationalization.app.internationalization.exception.MyValidationResponse.buildValidationResponse;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<MyExceptionResponse> handleException(Exception e) {
        var resposeBody = buildExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resposeBody);
    }

    @ExceptionHandler(MyBusinessException.class)
    private ResponseEntity<MyExceptionResponse> handleMyBusinessException(MyBusinessException e) {
        var resposeBody = buildExceptionResponse(HttpStatus.NOT_IMPLEMENTED.value(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(resposeBody);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<MyValidationResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        var errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> new MyFieldError(err.getField(), err.getDefaultMessage()))
                .toList();

        var resposeBody = buildValidationResponse(HttpStatus.BAD_REQUEST.value(), errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposeBody);
    }

}

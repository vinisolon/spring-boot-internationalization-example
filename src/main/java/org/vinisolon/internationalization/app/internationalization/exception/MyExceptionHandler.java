package org.vinisolon.internationalization.app.internationalization.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    private ResponseEntity<MyErrorResponse> handleException(Exception e) {
        var resposeBody = MyErrorResponse.buildMyErrorResponse(e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resposeBody);
    }

    @ExceptionHandler(MyBusinessException.class)
    private ResponseEntity<MyErrorResponse> handleMyBusinessException(MyBusinessException e) {
        var resposeBody = MyErrorResponse.buildMyErrorResponse(e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resposeBody);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<MyErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .toList()
                .toString();

        var resposeBody = MyErrorResponse.buildMyErrorResponse(errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposeBody);
    }

}

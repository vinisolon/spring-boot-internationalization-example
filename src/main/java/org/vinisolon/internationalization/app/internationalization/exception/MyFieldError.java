package org.vinisolon.internationalization.app.internationalization.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class MyFieldError {

    private String field;
    private String message;

}

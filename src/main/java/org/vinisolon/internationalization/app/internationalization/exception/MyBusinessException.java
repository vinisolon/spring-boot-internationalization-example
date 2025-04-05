package org.vinisolon.internationalization.app.internationalization.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.vinisolon.internationalization.app.internationalization.domain.MyDomainMessageKeyEnum;

@Getter
public abstract class MyBusinessException extends RuntimeException {

    private final HttpStatus httpStatus;

    protected MyBusinessException(MyDomainMessageKeyEnum messageKey) {
        super(messageKey.getKey());
        this.httpStatus = messageKey.getHttpStatus();
    }

}

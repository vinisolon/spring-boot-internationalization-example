package org.vinisolon.internationalization.app.internationalization.domain;

import org.vinisolon.internationalization.app.internationalization.exception.MyBusinessException;

public class MyDomainException extends MyBusinessException {

    public MyDomainException(String message) {
        super(message);
    }

}

package org.vinisolon.internationalization.app.internationalization.domain;

import org.vinisolon.internationalization.app.internationalization.exception.MyBusinessException;

public class MyDomainException extends MyBusinessException {

    public MyDomainException(MyDomainMessageKeyEnum messageKey) {
        super(messageKey);
    }

}

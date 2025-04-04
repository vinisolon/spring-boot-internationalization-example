package org.vinisolon.internationalization.app.internationalization.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum MyDomainMessageKeyEnum {

    DOMAIN_DEFAULT_MESSAGE_KEY(HttpStatus.NOT_IMPLEMENTED, "domain.default.message");

    private final HttpStatus httpStatus;
    private final String key;

}

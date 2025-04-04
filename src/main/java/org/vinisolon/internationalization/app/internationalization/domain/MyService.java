package org.vinisolon.internationalization.app.internationalization.domain;

import org.springframework.stereotype.Service;

import static org.vinisolon.internationalization.app.internationalization.domain.MyDomainMessageKeyEnum.DOMAIN_DEFAULT_MESSAGE_KEY;

@Service
public class MyService {

    public void process() {
        throw new MyDomainException(DOMAIN_DEFAULT_MESSAGE_KEY);
    }

}

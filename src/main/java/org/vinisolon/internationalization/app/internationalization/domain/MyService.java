package org.vinisolon.internationalization.app.internationalization.domain;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void process() {
        throw new MyDomainException("My domain exception was thrown");
    }

}

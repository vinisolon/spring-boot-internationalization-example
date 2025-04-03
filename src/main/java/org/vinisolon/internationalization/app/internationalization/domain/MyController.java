package org.vinisolon.internationalization.app.internationalization.domain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internationalization")
public class MyController {

    private final MyService myService;

    @PostMapping
    public ResponseEntity<Void> call(@Valid @RequestBody MyRequest request) {
        myService.process();
        return ResponseEntity.noContent().build();
    }

}

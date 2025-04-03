package org.vinisolon.internationalization.app.internationalization.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Builder
public class MyErrorResponse {

    private String message;

    @Builder.Default
    @Setter(AccessLevel.PRIVATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();

    public static MyErrorResponse buildMyErrorResponse(String message) {
        return MyErrorResponse.builder()
                .message(message)
                .build();
    }

}

package org.vinisolon.internationalization.app.internationalization.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
public class MyExceptionResponse {

    @Builder.Default
    @Setter(AccessLevel.PRIVATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();

    private Integer status;

    private String message;

    public static MyExceptionResponse buildExceptionResponse(Integer status, String message) {
        return MyExceptionResponse.builder()
                .status(status)
                .message(message)
                .build();
    }

}

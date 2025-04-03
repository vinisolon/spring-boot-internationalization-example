package org.vinisolon.internationalization.app.internationalization.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@ToString
public class MyValidationResponse {

    @Builder.Default
    @Setter(AccessLevel.PRIVATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();

    private Integer status;

    private List<MyFieldError> errors;

    public static MyValidationResponse buildValidationResponse(Integer status, List<MyFieldError> errors) {
        return MyValidationResponse.builder()
                .status(status)
                .errors(errors)
                .build();
    }

}

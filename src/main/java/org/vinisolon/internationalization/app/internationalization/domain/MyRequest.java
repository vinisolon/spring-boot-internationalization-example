package org.vinisolon.internationalization.app.internationalization.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MyRequest {

    @NotBlank(message = "text cannot be blank or null")
    private String text;

    @NotNull(message = "value cannot or null")
    private Integer value;

}

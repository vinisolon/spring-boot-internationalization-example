package org.vinisolon.internationalization.app.internationalization.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MyRequest {

    @NotBlank(message = "{text.not.blank}")
    private String text;

    @NotNull(message = "{value.not.null}")
    private Integer value;

}

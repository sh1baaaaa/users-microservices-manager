package ru.app.shiba.authservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class ResponseMessageDTO {

    private String message;

    private Boolean success;

    private String error;

}

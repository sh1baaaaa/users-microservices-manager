package ru.app.shiba.userservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Data
public class ResponseMessage {

    private String message;

    private Boolean success;

    private String error;
}

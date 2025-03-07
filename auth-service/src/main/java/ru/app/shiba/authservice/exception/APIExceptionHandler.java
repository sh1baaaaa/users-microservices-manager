package ru.app.shiba.authservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.app.shiba.authservice.dto.ResponseMessageDTO;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<ResponseMessageDTO> handleLoginException(LoginException ex) {
        return new ResponseEntity<>(ResponseMessageDTO.builder()
                .message("Bad credentials")
                .success(false)
                .build(), HttpStatus.UNAUTHORIZED);
    }

}

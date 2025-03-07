package ru.app.shiba.userservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.app.shiba.userservice.dto.ResponseMessage;

@Slf4j
@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ResponseMessage> handleEntityProcessingException(EntityProcessingException ex) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .message("Unsuccessful request")
                .success(false)
                .error(ex.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ResponseMessage> serviceExceptionHandler(Exception ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(ResponseMessage.builder()
                .error("Internal server error")
                .success(false)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

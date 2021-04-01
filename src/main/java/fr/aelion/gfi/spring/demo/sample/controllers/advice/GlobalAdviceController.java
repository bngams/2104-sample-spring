package fr.aelion.gfi.spring.demo.sample.controllers.advice;

import fr.aelion.gfi.spring.demo.sample.annotations.GlobalAdvice;
import fr.aelion.gfi.spring.demo.sample.exceptions.ApiError;
import fr.aelion.gfi.spring.demo.sample.exceptions.UserNotFoundException;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = GlobalAdvice.class)
@Log
public class GlobalAdviceController {

    @ExceptionHandler({UserNotFoundException.class, IllegalArgumentException.class})
    public ResponseEntity<ApiError> handleUserNotFoundException(Exception e) {
        if(e instanceof UserNotFoundException) {
            log.info(e.getMessage());
            return new ResponseEntity<>(ApiError.USER_NOT_FOUND, ApiError.USER_NOT_FOUND.getHttpStatus());
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

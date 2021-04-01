package fr.aelion.gfi.spring.demo.sample.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiError {
    USER_NOT_FOUND(1204, "Continue", HttpStatus.NOT_FOUND);

    private final int code;
    private final String msg;
    private final HttpStatus httpStatus;

    ApiError(int code, String msg, HttpStatus status) {
        this.code = code;
        this.msg = msg;
        this.httpStatus = status;
    }
}

package org.dreamdevzone.hospital.exception;

import io.github.pasinduog.dto.ApiResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Objects;

@RestControllerAdvice
@SuppressWarnings("unused")
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseNotFoundException.class)
    public ResponseEntity<@NotNull ApiResponse<Void>> handleException(BaseNotFoundException ex){
        return ApiResponse.status(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<@NotNull ApiResponse<Void>> handleException(MethodArgumentNotValidException ex){
        return ApiResponse.status(Objects.requireNonNull(ex.getBindingResult().getFieldError()).getDefaultMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<@NotNull ApiResponse<Void>> handleException(MethodArgumentTypeMismatchException ex){
        return ApiResponse.status(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

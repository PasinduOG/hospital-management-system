package org.dreamdevzone.hospital.util;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {
    private final String message;
    private final T data;
    private final LocalDateTime timestamp;

    private ApiResponse(String message, T data){
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public static<T> ResponseEntity<@NotNull ApiResponse<T>> created(String message, T data){
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(message, data));
    }

    public static ResponseEntity<@NotNull ApiResponse<Void>> success(String message){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(message, null));
    }

    public static<T> ResponseEntity<@NotNull ApiResponse<T>> success(String message, T data){
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(message, data));
    }

    public static ResponseEntity<@NotNull ApiResponse<Void>> status(String message, HttpStatus status){
        return ResponseEntity.status(status).body(new ApiResponse<>(message, null));
    }

    public static<T> ResponseEntity<@NotNull ApiResponse<T>> status(String message, T data, HttpStatus status){
        return ResponseEntity.status(status).body(new ApiResponse<>(message, data));
    }
}

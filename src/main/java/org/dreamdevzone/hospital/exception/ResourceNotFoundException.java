package org.dreamdevzone.hospital.exception;

import io.github.pasinduog.exception.ApiException;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {

    /**
     * Constructs a new ApiException with a detailed message and specific HTTP status.
     *
     * @param message The detail message explaining the cause of the error.
     * @param status  The {@link HttpStatus} to be returned to the client.
     */
    public ResourceNotFoundException(String message, HttpStatus status) {
        super(message, status);
    }
}

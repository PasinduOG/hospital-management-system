package org.dreamdevzone.hospital.exception;

public class BaseNotFoundException extends RuntimeException {
    public BaseNotFoundException(String message){
        super(message);
    }
}

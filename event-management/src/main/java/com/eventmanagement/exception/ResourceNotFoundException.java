// com.eventmanagement.exception.ResourceNotFoundException.java
package com.eventmanagement.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
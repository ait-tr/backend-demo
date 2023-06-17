package de.ait.todo.exceptions;

/**
 * 6/15/2023
 * spring-security-demo
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

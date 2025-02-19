package org.abpira.inventoryservice.exception;

public class ProductDoesNotExistsException extends RuntimeException {
    public ProductDoesNotExistsException(String message) {
        super(message);
    }
}

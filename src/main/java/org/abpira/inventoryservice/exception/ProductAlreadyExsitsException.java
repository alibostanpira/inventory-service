package org.abpira.inventoryservice.exception;

public class ProductAlreadyExsitsException extends RuntimeException {
    public ProductAlreadyExsitsException(String message) {
        super(message);
    }
}

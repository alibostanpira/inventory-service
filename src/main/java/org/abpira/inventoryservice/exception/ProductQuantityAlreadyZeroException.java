package org.abpira.inventoryservice.exception;

public class ProductQuantityAlreadyZeroException extends RuntimeException {
    public ProductQuantityAlreadyZeroException(String message) {
        super(message);
    }
}

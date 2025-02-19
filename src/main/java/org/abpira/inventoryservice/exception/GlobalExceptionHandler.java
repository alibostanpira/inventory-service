package org.abpira.inventoryservice.exception;


import org.abpira.inventoryservice.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductAlreadyExsitsException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductAlreadyExitsException(ProductAlreadyExsitsException ex,
                                                                               WebRequest request) {
        return new ResponseEntity<>(ErrorResponseDTO.builder()
                .path(request.getDescription(false))
                .status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductDoesNotExistsException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductDoesNotExistsException(ProductDoesNotExistsException ex,
                                                                                WebRequest request) {
        return new ResponseEntity<>(ErrorResponseDTO.builder()
                .path(request.getDescription(false))
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductQuantityAlreadyZeroException.class)
    public ResponseEntity<ErrorResponseDTO> handleProductQuantityAlreadyZeroException(ProductQuantityAlreadyZeroException ex,
                                                                                WebRequest request) {
        return new ResponseEntity<>(ErrorResponseDTO.builder()
                .path(request.getDescription(false))
                .status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }
}

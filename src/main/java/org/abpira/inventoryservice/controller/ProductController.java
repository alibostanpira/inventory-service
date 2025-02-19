package org.abpira.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import org.abpira.inventoryservice.dto.ProductDTO;
import org.abpira.inventoryservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> checkProductExists(@PathVariable Long id) {
        return ResponseEntity.ok(productService.checkProductExists(id));
    }
}

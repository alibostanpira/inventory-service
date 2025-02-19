package org.abpira.inventoryservice.controller;


import lombok.RequiredArgsConstructor;
import org.abpira.inventoryservice.dto.ProductDTO;
import org.abpira.inventoryservice.dto.StockDTO;
import org.abpira.inventoryservice.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping("/{id}")
    public ResponseEntity<ProductDTO> addProductToStock(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.addProductToStock(id));
    }

    @GetMapping
    public ResponseEntity<List<StockDTO>> getStock() {
        return ResponseEntity.ok(stockService.getStock());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> removeProductFromStock(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.removeProductFromStock(id));
    }
}

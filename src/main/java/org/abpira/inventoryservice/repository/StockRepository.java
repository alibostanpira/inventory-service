package org.abpira.inventoryservice.repository;

import org.abpira.inventoryservice.entities.Product;
import org.abpira.inventoryservice.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByProduct(Product product);
}
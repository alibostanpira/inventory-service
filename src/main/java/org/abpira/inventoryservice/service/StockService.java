package org.abpira.inventoryservice.service;

import org.abpira.inventoryservice.dto.ProductDTO;
import org.abpira.inventoryservice.dto.StockDTO;

import java.util.List;

public interface StockService {
    ProductDTO addProductToStock(Long id);

    List<StockDTO> getStock();

    ProductDTO removeProductFromStock(Long id);
}

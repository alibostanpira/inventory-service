package org.abpira.inventoryservice.mapper;

import org.abpira.inventoryservice.dto.StockDTO;
import org.abpira.inventoryservice.entities.Stock;

public class StockMapper {

    public static Stock mapToStock(StockDTO stockDTO) {
        return Stock.builder()
                .id(stockDTO.getId())
                .quantity(stockDTO.getQuantity())
                .product(stockDTO.getProduct())
                .build();
    }

    public static StockDTO mapToStockDTO(Stock stock) {
        return StockDTO.builder()
                .id(stock.getId())
                .quantity(stock.getQuantity())
                .product(stock.getProduct())
                .build();
    }
}

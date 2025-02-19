package org.abpira.inventoryservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.abpira.inventoryservice.entities.Product;

@Getter
@Setter
@Builder
public class StockDTO {
    private Long id;
    private Integer quantity;
    private Product product;
}

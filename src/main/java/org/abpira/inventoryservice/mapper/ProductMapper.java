package org.abpira.inventoryservice.mapper;

import org.abpira.inventoryservice.dto.ProductDTO;
import org.abpira.inventoryservice.entities.Product;

public class ProductMapper {

    public static ProductDTO mapToProductDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();
    }

    public static Product mapToProduct(ProductDTO productDTO) {
        return Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .category(productDTO.getCategory())
                .build();
    }
}

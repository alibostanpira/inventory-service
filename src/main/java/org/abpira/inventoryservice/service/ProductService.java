package org.abpira.inventoryservice.service;

import org.abpira.inventoryservice.dto.ProductDTO;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDto);
    ProductDTO getProduct(Long id);
    Boolean checkProductExists(Long id);
}

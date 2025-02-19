package org.abpira.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import org.abpira.inventoryservice.dto.ProductDTO;
import org.abpira.inventoryservice.entities.Product;
import org.abpira.inventoryservice.exception.ProductAlreadyExsitsException;
import org.abpira.inventoryservice.exception.ProductDoesNotExistsException;
import org.abpira.inventoryservice.mapper.ProductMapper;
import org.abpira.inventoryservice.repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDto) {
        productRepository.findByName(productDto.getName()).ifPresent(product -> {
            throw new ProductAlreadyExsitsException("Product already exists");
        });
        Product product = productRepository.save(ProductMapper.mapToProduct(productDto));
        return ProductMapper.mapToProductDTO(product);
    }

    @Override
    public ProductDTO getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new ProductDoesNotExistsException("Product not found"));
        return ProductMapper.mapToProductDTO(product);
    }

    @Override
    public Boolean checkProductExists(Long id) {
        return productRepository.existsById(id);
    }
}

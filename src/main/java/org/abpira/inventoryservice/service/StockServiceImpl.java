package org.abpira.inventoryservice.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.abpira.inventoryservice.dto.ProductDTO;
import org.abpira.inventoryservice.dto.StockDTO;
import org.abpira.inventoryservice.entities.Product;
import org.abpira.inventoryservice.entities.Stock;
import org.abpira.inventoryservice.exception.ProductDoesNotExistsException;
import org.abpira.inventoryservice.exception.ProductQuantityAlreadyZeroException;
import org.abpira.inventoryservice.mapper.ProductMapper;
import org.abpira.inventoryservice.mapper.StockMapper;
import org.abpira.inventoryservice.repository.ProductRepository;
import org.abpira.inventoryservice.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public ProductDTO addProductToStock(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductDoesNotExistsException("Product not found"));

        Stock stock = stockRepository.findByProduct(product)
                .map(existingStock -> {
                    existingStock.setQuantity(existingStock.getQuantity() + 1);
                    return existingStock;
                })
                .orElseGet(() -> new Stock(1, product));

        stockRepository.save(stock);
        return ProductMapper.mapToProductDTO(product);
    }

    @Override
    public List<StockDTO> getStock() {
        if (productRepository.count() == 0) {
            throw new ProductDoesNotExistsException("There is no product, please add a product first.");
        }
        return stockRepository.findAll().stream()
                .map(StockMapper::mapToStockDTO)
                .toList();
    }

    @Override
    public ProductDTO removeProductFromStock(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductDoesNotExistsException("Product not found"));

        Stock stock = stockRepository.findByProduct(product)
                .map(existingStock -> {
                    if (existingStock.getQuantity() == 0) {
                        throw new ProductQuantityAlreadyZeroException("The quantity of this product is already zero. No further reduction is possible.");
                    }
                    existingStock.setQuantity(existingStock.getQuantity() - 1);
                    return existingStock;
                })
                .orElseGet(() -> new Stock(1, product));

        stockRepository.save(stock);
        return ProductMapper.mapToProductDTO(product);
    }
}

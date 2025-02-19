package org.abpira.inventoryservice.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "stocks", indexes = {@Index(name = "idx_product_id", columnList = "productId")})
public class Stock extends BaseEntity {

    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "productId", nullable = false, unique = true)
    private Product product;
}

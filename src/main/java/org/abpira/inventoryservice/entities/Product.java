package org.abpira.inventoryservice.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product extends BaseEntity {

    private String name;
    private String description;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    private String category;
}

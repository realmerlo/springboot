package com.example.repositories1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "modelName", nullable = false)
    private String modelName;
    @Column(name = "serialNumber", nullable = false)
    private int serialNumber;
    @Column(name = "currentPrice", nullable = false)
    private BigDecimal currentPrice;

}

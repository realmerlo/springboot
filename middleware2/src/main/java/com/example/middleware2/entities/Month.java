package com.example.middleware2.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Month {
    private int monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;

}
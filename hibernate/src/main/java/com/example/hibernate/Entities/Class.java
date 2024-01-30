package com.example.hibernate.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

    @Table
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    public class Class {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(nullable = false)
        private String title;

        @Column(nullable = false)
        private String description;

        @OneToMany(mappedBy = "class")
        private List<Enrollments> enrollments = new ArrayList<>();
    }


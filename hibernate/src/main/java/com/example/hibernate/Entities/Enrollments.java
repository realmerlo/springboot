package com.example.hibernate.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @Column(name = "student_id")
    private Student student;


    @ManyToOne
    @Column(name = "class_id")
    private Class aClass;
}

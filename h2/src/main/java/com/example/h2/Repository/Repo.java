package com.example.h2.Repository;

import com.example.h2.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class Repo {
    public interface StudentRepository extends JpaRepository<Student, Long> {
    }
}
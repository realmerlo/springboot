package com.example.testCrud.repository;

    import com.example.testCrud.entities.Student;
    import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface Repo extends JpaRepository<Student, Long> {
    }


package com.example.crud.repository;

import com.example.crud.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends JpaRepository<CarEntity, Long> {

}
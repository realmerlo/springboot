package com.example.repositories1.repositories;

import com.example.repositories1.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface Repo extends JpaRepository<Car, Long> {

}

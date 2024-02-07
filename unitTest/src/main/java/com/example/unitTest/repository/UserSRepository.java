package com.example.unitTest.repository;

import com.example.unitTest.entities.UserS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSRepository extends JpaRepository<UserS, Long> {

}
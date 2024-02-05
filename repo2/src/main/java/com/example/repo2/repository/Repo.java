package com.example.repo2.repository;


import com.example.repo2.entities.ProgLenguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "repo-prog-languages", collectionResourceDescription = @Description("Description"))
public interface Repo extends JpaRepository<ProgLenguage, Long> {
}
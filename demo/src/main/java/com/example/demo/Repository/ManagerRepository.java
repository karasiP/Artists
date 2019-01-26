package com.example.demo.Repository;

import com.example.demo.Entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
@RepositoryRestController

public interface ManagerRepository extends JpaRepository <Manager,Long>{
    Manager findById(long id);
    Manager findByUsername(String username);
}

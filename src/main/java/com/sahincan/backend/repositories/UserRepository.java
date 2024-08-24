package com.sahincan.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahincan.backend.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User , Long> {
    
}

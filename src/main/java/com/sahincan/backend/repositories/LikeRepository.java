package com.sahincan.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahincan.backend.entities.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like , Long > {
    
}

package com.sahincan.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahincan.demo.entities.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like , Long > {
    
}

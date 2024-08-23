package com.sahincan.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahincan.demo.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment , Long >{
    
}

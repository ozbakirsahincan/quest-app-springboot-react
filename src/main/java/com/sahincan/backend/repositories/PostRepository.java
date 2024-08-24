package com.sahincan.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahincan.backend.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post , Long> {

    // Jpa findBy ile başlığı için methodu kendisi çözüyor
    // Araştır
    List<Post> findByUserId(Long userId);
    
}

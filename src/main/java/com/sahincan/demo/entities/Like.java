package com.sahincan.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "p_like")
public record Like(@Id Long id,Long postId,Long userId) {
    
}

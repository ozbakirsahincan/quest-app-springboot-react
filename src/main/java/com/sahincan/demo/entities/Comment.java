package com.sahincan.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="comment")
public record Comment(@Id Long id,Long postId,Long userId, @Lob @Column(columnDefinition = "text") String text) {
    
}

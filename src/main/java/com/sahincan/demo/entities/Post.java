package com.sahincan.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public record Post(
        @Id Long id,
        Long userId,
        String title,
        @Lob @Column(columnDefinition = "text")  String text) {
 
}

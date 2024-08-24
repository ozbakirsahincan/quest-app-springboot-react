package com.sahincan.backend.requests;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// @Data
// public class PostCreateRequest {
//     private Long id;
//     private String text;
//     private String title;
//     private Long userId;
// }

public record PostCreateRequest(
    
@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
Long id,
String text , 
String title, 
Long userId
){}

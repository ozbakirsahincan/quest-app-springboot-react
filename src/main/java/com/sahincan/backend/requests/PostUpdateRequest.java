package com.sahincan.backend.requests;

import lombok.Data;

@Data
public class PostUpdateRequest {
    private String title;
    private String text;
}

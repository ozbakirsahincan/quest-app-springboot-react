package com.sahincan.backend.responses;

import com.sahincan.backend.entities.Post;

import lombok.Data;

@Data
public class PostResponse {
    private Long id;
    private String title;
    private String text;
    private Long userId;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.text = post.getText();
        this.userId = post.getUser().getId(); // İlgili userId'yi alıyoruz.
    }
}


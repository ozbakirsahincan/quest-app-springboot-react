package com.sahincan.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sahincan.backend.entities.Comment;
import com.sahincan.backend.requests.CommentCreateRequest;
import com.sahincan.backend.requests.CommentUpdateRequest;
import com.sahincan.backend.services.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
        return commentService.getAllCommentsWithParam(userId,postId);
    }

    // GET - Endpoint: /comments/{commentId}
    @GetMapping("/{commentId}")
    public Comment getOneComment(@PathVariable Long commentId )
    {
        return commentService.getOneCommentById(commentId);
    }

    // POST - Endpoint: /comments
    @PostMapping
    public Comment createOneComment(@RequestBody CommentCreateRequest request )
    {
        return commentService.createOneComment(request);
    }

    // PUT - Endpoint: /comments/{commentId}
    @PutMapping("/{commentId}")
    public Comment updateOneComment(@PathVariable Long commentId , @RequestBody CommentUpdateRequest request) 
    {
        return commentService.updateOneCommentById(commentId , request);
    }

    @DeleteMapping("/{commentId}")
    public void deleteOneComment(@PathVariable Long commentId)
    {
        commentService.deleteOneCommentById(commentId);
    }

}
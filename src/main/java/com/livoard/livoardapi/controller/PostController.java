package com.livoard.livoardapi.controller;

import com.livoard.livoardapi.dto.*;
import com.livoard.livoardapi.entity.Post;
import com.livoard.livoardapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<PostResponse> getAllPosts() {
        return service.getAllPosts();
    }

    @PostMapping
    public PostResponse createPost(@RequestBody PostCreateRequest req) {
        return service.createPost(req);
    }

    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable UUID id) {
        return service.getPostById(id);
    }

    @PutMapping("/{id}")
    public PostResponse updatePost(@PathVariable UUID id, @RequestBody PostUpdateRequest req) {
        return service.updatePost(id, req);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable UUID id) {
        if (service.deletePost(id)) {
            return "게시글이 삭제되었습니다.";
        }
        return "게시글을 찾을 수 없습니다.";
    }
}
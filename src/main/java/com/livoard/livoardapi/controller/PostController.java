package com.livoard.livoardapi.controller;

import com.livoard.livoardapi.entity.Post;
import com.livoard.livoardapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable UUID id) {
        return postRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable UUID id, @RequestBody Post postDetails) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setTitle(postDetails.getTitle());
            post.setContents(postDetails.getContents());
            return postRepository.save(post);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable UUID id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return "게시글이 삭제되었습니다.";
        }
        return "게시글을 찾을 수 없습니다.";
    }
}
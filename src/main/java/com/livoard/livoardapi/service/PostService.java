package com.livoard.livoardapi.service;

import com.livoard.livoardapi.entity.Post;
import com.livoard.livoardapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostById(UUID id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post updatePost(UUID id, Post postDetails) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setTitle(postDetails.getTitle());
            post.setContents(postDetails.getContents());
            return postRepository.save(post);
        }
        return null;
    }

    public boolean deletePost( UUID id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
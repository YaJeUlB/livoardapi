package com.livoard.livoardapi.service;

import com.livoard.livoardapi.dto.*;
import com.livoard.livoardapi.entity.Post;
import com.livoard.livoardapi.mapper.PostMapper;
import com.livoard.livoardapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PostService {

    @Autowired
    private final PostRepository repo;
    private final PostMapper mapper;

    public PostService(PostRepository repo, PostMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public List<PostResponse> getAllPosts() {
        return mapper.toResponseList(repo.findAll());
    }

    public PostResponse createPost(PostCreateRequest req) {
        Post post = mapper.toEntity(req);
        Post saved = repo.save(post);
        return mapper.toResponse(saved);
    }

    public PostResponse getPostById(UUID id) {
        Post post = repo.findById(id).orElse(null);
        return mapper.toResponse(post);
    }

    public PostResponse updatePost(UUID id, PostUpdateRequest req) {
        Post post = repo.findById(id).orElse(null);
        mapper.overwrite(post, req);
        return mapper.toResponse(post);
    }

    public boolean deletePost(UUID id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
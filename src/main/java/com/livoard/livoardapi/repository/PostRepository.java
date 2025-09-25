package com.livoard.livoardapi.repository;

import com.livoard.livoardapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
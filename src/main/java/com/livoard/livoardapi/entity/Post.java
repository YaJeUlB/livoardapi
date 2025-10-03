package com.livoard.livoardapi.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private UUID id;

    @GeneratedValue
    @Column(name = "post_num")
    private Long num;

    @Column(length=255)
    private String title;

    @Column
    private String contents;

    @GeneratedValue
    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    protected Post() {}

    public Post(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public UUID getId() {
        return id;
    }

    /*
    public void setId(UUID id) {
        this.id = id;
    }

     */

    public Long getNum() {
        return num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    // toString 메소드 (디버깅용)
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", created_at=" + createdAt +
                '}';
    }
}
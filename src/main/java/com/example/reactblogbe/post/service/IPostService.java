package com.example.reactblogbe.post.service;

import com.example.reactblogbe.post.model.Post;

import java.util.List;

public interface IPostService {
    List<Post> findAll();
    Post findById(long id);
    Post save(Post post);
    void delete(long id);
}

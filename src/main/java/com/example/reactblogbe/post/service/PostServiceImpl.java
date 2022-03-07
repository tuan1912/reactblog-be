package com.example.reactblogbe.post.service;

import com.example.reactblogbe.post.model.Post;
import com.example.reactblogbe.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements IPostService{
    @Autowired
    PostRepository postRepository;
    @Override
    public List<Post> findAll() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
    }
}

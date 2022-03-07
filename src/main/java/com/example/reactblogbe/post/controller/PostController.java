package com.example.reactblogbe.post.controller;


import com.example.reactblogbe.post.model.Post;

import com.example.reactblogbe.post.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostServiceImpl postService;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable long id) {
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post) {
        postService.save(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        postService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@RequestBody Post post ) {
        postService.save(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
package com.example.demospringmvc.service;

import com.example.demospringmvc.model.Post;

import java.util.Date;
import java.util.List;

public interface IPostService {
    List<Post> findAllPost();
    List<Post> findAllPostByTitleOrContent(String search);
    void  addPost(Post post);
    void  updatePost(Post post);
    void  deletePost(int id);
    Post findById(int id);

}

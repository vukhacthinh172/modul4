package com.example.demospringmvc.dao;

import com.example.demospringmvc.model.Post;

import java.util.Date;
import java.util.List;

public interface IPostDao {
    List<Post> findAllPost();
    List<Post> findAllPostByTitleOrContent(String search);
    void  addPost(Post p);
    void  updatePost(Post post);
  void  deletePost(int id);
  Post  findPostById(int id);
}

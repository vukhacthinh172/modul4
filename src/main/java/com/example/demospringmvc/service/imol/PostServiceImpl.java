package com.example.demospringmvc.service.imol;

import com.example.demospringmvc.dao.IPostDao;
import com.example.demospringmvc.model.Post;
import com.example.demospringmvc.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    private IPostDao postDao;
    @Override
    public List<Post> findAllPost() {
      return   postDao.findAllPost();
    }
    @Override
    public List<Post> findAllPostByTitleOrContent(String search) {
        return postDao.findAllPostByTitleOrContent(search);
    }


    @Override
    public void addPost(Post post) {
       postDao.addPost(post);
    }

    @Override
    public void updatePost(Post post) {
        postDao.updatePost(post);
    }

    @Override
    public void deletePost(int id) {
        postDao.deletePost(id);
    }

    @Override
    public Post findById(int id) {
        return postDao.findPostById(id);
    }
}

package com.example.demospringmvc.dao.impl;

import com.example.demospringmvc.dao.IPostDao;
import com.example.demospringmvc.model.Post;
import com.example.demospringmvc.until.ConnectDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class PostDaoImpl implements IPostDao {
    @Override
    public List<Post> findAllPost() {
        List<Post> list = new ArrayList<>();
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("select *from  post");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setAuthor(rs.getString("author"));
                p.setContent(rs.getString("content"));
                p.setImageUrl(rs.getString("imageUrl"));
                p.setCreatedDate(rs.getTimestamp("createdAt").toLocalDateTime());
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return list;
    }

    @Override
    public List<Post> findAllPostByTitleOrContent(String search) {
        List<Post> list = new ArrayList<>();
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("select *from post where title like ? or content like ?");
            call.setString(1, "%" + search + "%");
            call.setString(2, "%" + search + "%");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Post p = new Post();
                p.setId(rs.getInt("id"));
                p.setTitle(rs.getString("title"));
                p.setAuthor(rs.getString("author"));
                p.setContent(rs.getString("content"));
                p.setImageUrl(rs.getString("imageUrl"));
                p.setCreatedDate(rs.getTimestamp("createdAt").toLocalDateTime());
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
        return list;

    }

    @Override
    public void addPost(Post p) {
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("insert into Post  (id, title, author, content, imageUrl, createdAt) VALUES (?,?, ?, ?, ?, ?)");
            call.setInt(1, p.getId());
            call.setString(2, p.getTitle());
            call.setString(3, p.getAuthor());
            call.setString(4, p.getContent());
            call.setString(5, p.getImageUrl());
            call.setTimestamp(6, Timestamp.valueOf(p.getCreatedDate()));
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void updatePost(Post post) {
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("UPDATE Post SET title = ?, author = ?, content = ?, imageUrl = ?, createdAt = ? WHERE id = ?");

            call.setString(1, post.getTitle());
            call.setString(2, post.getAuthor());
            call.setString(3, post.getContent());
            call.setString(4, post.getImageUrl());
            call.setTimestamp(5, Timestamp.valueOf(post.getCreatedDate()));
            call.setInt(6, post.getId());
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void deletePost(int id) {
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("DELETE FROM Post WHERE id = ?");
          call.setInt(1,id);
            call.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public Post findPostById(int id) {
        Post post = null;
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("select * from post where id = ? ");
            call.setInt(1,id);
            ResultSet rs = call.executeQuery();
            if (rs.next()){
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setTitle(rs.getString("title"));
                post.setAuthor(rs.getString("author"));
                post.setContent(rs.getString("content"));
                post.setImageUrl(rs.getString("imageUrl"));
                post.setCreatedDate(rs.getTimestamp("createdAt").toLocalDateTime());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
        return post ;
    }
}

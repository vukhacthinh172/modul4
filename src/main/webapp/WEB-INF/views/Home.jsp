<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: vukha
  Date: 10/01/2024
  Time: 10:34 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center">Danh sách bài đăng</h1>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01"><a class="navbar-brand" href="#">Hidden brand</a>
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                </ul>
                <form class="d-flex" action="/search" method="get">
                    <input class="form-control me-2" type="text" name="search" value="${search}" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </div>
    </nav>
    <c:forEach items="${list}" var="post">
        <div class="card w-100 my-3">
            <p class="fs-6"> ${post.createdDate} </p>
            <img src="${post.imageUrl}" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">${post.title}</h5>
                <p class="card-text">${post.content}</p>
                <span class="btn btn-danger">${post.author}</span>
                <a href="/delete?id=${post.id}">Delete</a>
<%--                update                             --%>
                <a href="/update/${post.id}">Update</a>
    </c:forEach>
    <!-- Modal Add -->
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#addModal" data-bs-whatever="@getbootstrap">ADD NEW POST</button>
    <div class="modal fade" id="addModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/add" method="post">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5">Add New Post</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="mb-3">
                                <label for="post_id" class="form-label">Id</label>
                                <input type="text" class="form-control" name="id" id="post_id">
                            </div>

                            <div class="mb-3">
                                <label for="post_title" class="form-label">Title</label>
                                <textarea class="form-control" name="title" rows="3" id="post_title"></textarea>
                            </div>
                            <div class="mb-3">
                                <label for="post_author" class="form-label">Author</label>
                                <input type="text" class="form-control" name="author" id="post_author">
                            </div>
                            <div class="mb-3">
                                <label for="post_content" class="form-label">conten</label>
                                <input type="text" name="content" class="form-control" id="post_content">
                            </div>
                            <div class="mb-3">
                                <label for="post_imageUrl" class="form-label">imageUrl</label>
                                <input type="text" name="imageUrl" class="form-control" id="post_imageUrl">
                            </div>
                            <div class="mb-3">
                                <label for="post_createdAt" class="form-label">createdAt</label>
                                <input type="datetime-local" name="createdDate" class="form-control" id="post_createdAt">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">ADD</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>
        </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>

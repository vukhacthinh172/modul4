<%--
  Created by IntelliJ IDEA.
  User: vukha
  Date: 14/01/2024
  Time: 11:19 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
                <div class="modal-dialog">
                    <form action="/update" method="post">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5">Update Post</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div class="mb-3">
                                        <label for="id" class="form-label">Id</label>
                                        <input type="text" class="form-control" value="${post.id}" name="id" id="id">
                                    </div>

                                    <div class="mb-3">
                                        <label for="title" class="form-label">Title</label>
                                        <textarea class="form-control" name="title" rows="3" id="title">${post.title}</textarea>
                                    </div>
                                    <div class="mb-3">
                                        <label for="author" class="form-label">Author</label>
                                        <input type="text" class="form-control" value="${post.author}" name="author" id="author">
                                    </div>
                                    <div class="mb-3">
                                        <label for="content" class="form-label">conten</label>
                                        <input type="text" name="content" value="${post.content}" class="form-control" id="content">
                                    </div>
                                    <div class="mb-3">
                                        <label for="imageUrl" class="form-label">imageUrl</label>
                                        <input type="text" value="${post.imageUrl}" name="imageUrl" class="form-control" id="imageUrl">
                                    </div>
                                    <div class="mb-3">
                                        <label for="post_createdAt" class="form-label">createdAt</label>
                                        <input type="datetime-local" value="${post.createdDate}" name="createdDate" class="form-control" id="post_createdAt">
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">UPDATE</button>
                            </div>
                        </div>
                    </form>
                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: timwong5
  Date: 2022-05-30
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书库</title>

    <%--bootstrap 美化页面--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <%--清除浮动--%>
    <div class="row clearfix">
        <%--分成12格--%>
        <div class="col-md-12 column">
            <%----%>
            <div class="page-header">
                <h1>
                    <small>书籍列表</small>
                </h1>
            </div>

            <div class="row">
                <div class="col-md-4 column">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">添加书籍</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示全部</a>
                </div>
                <div class="col-md-4 column">
                    <span style="color: red ;font-weight: bold ;text-align: center; font-size: large">${error}</span>
                </div>

                <div class="col-md-4 column">
                    <form action="${pageContext.request.contextPath}/book/queryBook" method="post" style="float: right">
                        <%--                        前端传入的name要和controller的参数 bookName 保持一致--%>
                        <input type="text" name="queryBookName" class="from-control" placeholder="请输入要查询的书籍">
                        <input type="submit" value="查询" class="btn btn-primary">
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>编码</th>
                    <th>书名</th>
                    <th>数量</th>
                    <th>简介</th>
                    <th>操作</th>
                </tr>
                </thead>
                <%--c:forEach,从数据库查询显示出来--%>
                <tbody>

                <c:forEach var="book" items="${list}">
                    <tr>
                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.bookID}">修改</a>
                            &nbsp; | &nbsp;
                            <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
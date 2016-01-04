<%--
  Created by IntelliJ IDEA.
  User: Sonny
  Date: 2015/12/26
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
<head>
    <jsp:include page="public/head.jsp"/>
    <title>comment list</title>
</head>
<body>
<jsp:include page="public/nav2.jsp"/>
<div class="ui container">
    <table class="ui inverted orange table">
    <thead>
        <tr>
            <th>#</th>
            <th>用户</th>
            <th>商品编号</th>
            <th>内容</th>
            <th>时间</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
        <s:iterator value="commentList" var="com" status="st">
            <tr>
                <td>${st.index+1}</td>
                <td>${com.owner}</td>
                <td>${com.product}</td>
                <td>${com.content}</td>
                <td>${com.createAt}</td>
                <td><a href="comment!deleteById?commentId=${com.id}">删除</a></td>
            </tr>
        </s:iterator>
    </tbody>
</table>
</div>
</body>
</html>

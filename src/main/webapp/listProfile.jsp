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
    <title>product list</title>
</head>
<body>
<jsp:include page="public/nav2.jsp"/>
<div class="ui container">
    <table class="ui inverted table">
    <thead>
        <tr>
            <th>#</th>
            <th>用户编号</th>
            <th>用户名</th>
            <th>邮箱</th>
            <th>地址</th>
            <th>手机</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
        <s:iterator value="profileList" var="pro" status="st">
            <tr>
                <td>${st.index+1}</td>
                <td>${pro.userId}</td>
                <td>${pro.name}</td>
                <td>${pro.email}</td>
                <td>${pro.address}</td>
                <td>${pro.mobile}</td>
                <td>${pro.tel}</td>
                <td><a href="profile!delete?profileId=${pro.id}">删除</a></td>
            </tr>
        </s:iterator>
    </tbody>
</table>
</div>
</body>
</html>

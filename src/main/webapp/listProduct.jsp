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
    <table class="ui inverted teal table">
    <thead>
        <tr>
            <th>#</th>
            <th>商品名</th>
            <th>商品类型</th>
            <th>商品描述</th>
            <th>价格</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
        <s:iterator value="productList" var="prod" status="st">
            <tr>
                <td>${st.index+1}</td>
                <td>${prod.name}</td>
                <td>${prod.type}</td>
                <td>${prod.description}</td>
                <td>${prod.price}</td>
                <td><a href="product!edit?productId=${prod.id}">修改</a>||<a href="product!delete?productId=${prod.id}">删除</a></td>
            </tr>
        </s:iterator>
    </tbody>
</table>
</div>
</body>
</html>

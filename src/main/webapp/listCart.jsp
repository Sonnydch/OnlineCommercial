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
    <title>购物车</title>
</head>
<body>
<jsp:include page="public/nav2.jsp"/>
<div class="ui container">
    <table class="ui inverted yellow table">
    <thead>
        <tr>
            <th>#</th>
            <th>商品编号</th>
            <th>商品名</th>
            <th>购买者编号</th>
            <th>购买者</th>
            <th>所有者</th>
            <th>生成时间</th>
            <th>操作</th>
        </tr>
    </thead>
    <tbody>
        <s:iterator value="cartItemList" var="car" status="st">
            <tr>
                <td>${st.index+1}</td>
                <td>${car.productId}</td>
                <td>${car.productName}</td>
                <td>${car.buyerId}</td>
                <td>${car.buyer}</td>
                <td>${car.sellerId}</td>
                <td>${car.createAt}</td>
                <td><a href="detailInfo?productId=${car.productId}">查看</a>||<a href="orderItem!addToPay?productId=${car.productId}">购买</a>||<a href="cart!deleteCartItem?cartItemId=${car.id}">删除</a></td>
            </tr>
        </s:iterator>
    </tbody>
</table>
</div>
</body>
</html>

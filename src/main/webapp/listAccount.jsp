<%--
  Created by IntelliJ IDEA.
  User: Sonny
  Date: 2015/12/27
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <jsp:include page="public/head.jsp"/>
    <title>order List</title>
</head>
<body>
<jsp:include page="public/nav2.jsp"/>
<div class="ui container">
    <form class="ui form" action="orderItem!addOrderItem" method="POST">
        <input hidden name="productId" value="${product.id}"/>
        <table class="ui inverted green table">
        <thead>
        <tr>
            <th>商品编号</th>
            <th>商品名</th>
            <th>售卖者</th>
            <th>价格</th>
        </tr>
        </thead>
        <tbody>
        <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.owner}</td>
                <td>${product.price}</td>
            </tr>
        </tbody>
    </table>
      <h2>总价:</h2>${amount}
        <button class="ui button" type="submit">确认结算</button>
   </form>
</div>
</body>
</html>

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
    <table class="ui inverted green table">
        <thead>
        <tr>
            <th>#</th>
            <th>订单号</th>
            <th>商品编号</th>
            <th>购买人</th>
            <th>售卖者</th>
            <th>状态</th>
            <th>时间</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="orderItemDetailList" var="order" status="st">
            <tr>
                <td onclick="goEdit(${order.id})">${st.index+1}</td>
                <td onclick="goEdit(${order.id})">${order.id}</td>
                <td onclick="goEdit(${order.id})">${order.product}</td>
                <td onclick="goEdit(${order.id})">${order.buyer}</td>
                <td onclick="goEdit(${order.id})">${order.seller}</td>
                <td onclick="goEdit(${order.id})">${order.status}</td>
                <td onclick="goEdit(${order.id})">${order.createAt}</td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>
<script>
    function goEdit(data){
        console.log(data);
    }
</script>
</body>
</html>

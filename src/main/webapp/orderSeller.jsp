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
    <table class="ui green table">
        <thead>
        <tr>
            <th>#</th>
            <th>订单号</th>
            <th>商品编号</th>
            <th>购买人</th>
            <th>售卖者</th>
            <th>时间</th>
            <th>状态</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="orderItemDetailList" var="ord" status="st">
            <tr>
                <td>${st.index+1}</td>
                <td>${ord.id}</td>
                <td>${ord.product}</td>
                <td>${ord.buyer}</td>
                <td>${ord.seller}</td>
                <td>
                <select name="status" onchange="goChange(this,${ord.id})">
                    <option value="buy" ${ord.status=='buy'?'selected':''}>已被购买</option>
                    <option value="ship" ${ord.status=='ship'?'selected':''}>发货</option>
                    <option value="finish" ${ord.status=='finish'?'selected':''}>完成</option>
                    <option value="fail" ${ord.status=='fail'?'selected':''}>失败</option>
                </select>
                </td>
                <td>${ord.createAt}</td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
</div>
<script>
    function goChange(e, id){
        var sta = e.value;
        console.log(sta);
        console.log(id);
        location.href = "orderItem!changeStatus?orderItemId="+id+"&status="+sta;
    }
</script>
</body>
</html>

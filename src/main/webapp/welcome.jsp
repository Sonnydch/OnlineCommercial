<%--
  Created by IntelliJ IDEA.
  User: Sonny
  Date: 2015/12/20
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Hello</title>
</head>
<body>
<a href="public/login.jsp">登录</a>
<a href="public/register.jsp">注册</a>
<h2>Welcome</h2>
<s:if test="#session.user!=null">
    <h2>Hello <s:property value="#session.user.name"/></h2>
</s:if>
</body>
</html>
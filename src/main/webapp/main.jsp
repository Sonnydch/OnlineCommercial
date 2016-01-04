<%--
  Created by IntelliJ IDEA.
  User: Sonny
  Date: 2015/12/20
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="public/head.jsp"/>
    <title>main</title>
</head>
<body>
    <jsp:include page="public/nav.jsp"/>
    <jsp:include page="public/register.jsp"/>
    <jsp:include page="public/login.jsp"/>
    <div class="ui bottom attached segment pushable">
        <div class="ui inverted left vertical sidebar menu">
            <jsp:include page="public/sidebarMenu.jsp"/>
        </div>
        <div class="pusher">
            <div class="ui container">
                <div class="ui five column grid">
                    <div class="row">
                        <div class="sixteen wide column">
                            <br/>
                            <h3 class="ui horizontal divider header">
                                <i class="tag icon"></i>
                                Hot
                            </h3>
                        </div>
                    </div>
                <s:iterator id="product" value="productList">
                    <div class="column">
                        <div class="ui fluid card link">
                           <a class="image" href="detailInfo?productId=${product.id}">
                                    <img src="./images/${product.cover}"/>
                                </a>
                           <div class="content">
                                    <div class="header">${product.name}</div>
                                    <div class="meta">
                                        <a href="detailInfo?productId=${product.id}">${product.type}||${product.price}</a>
                                    </div>
                                </div>
                        </div>
                    </div>
                </s:iterator>
            </div>
            </div>
        </div>
    </div>

    <jsp:include page="public/footer.jsp"/>
</body>
</html>
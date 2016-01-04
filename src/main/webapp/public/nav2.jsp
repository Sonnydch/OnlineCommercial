<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="ui red inverted attached stackable menu">
    <div class="ui container">
        <a class="item" href="index.jsp">
            <i class="home icon"></i>
            主页
        </a>
        <div class="item">
            <form  action="product!searchByText" method="post">
                <div class="ui input"><input name="text" type="text" placeholder="Search..."></div>
                <button type="submit" class="ui button inverted">Go!</button>
            </form>
        </div>
        <div class="right item">
            <div class="ui simple dropdown">
                <s:if test="#session.user == null">
                    <img class="ui avatar image" src="images/image.png">
                    <i class="dropdown icon"></i>
                    <div class="menu">
                        <a class="item log"><i class="user icon"></i>登录</a>
                        <a class="item reg"><i class="add user icon"></i>注册</a>
                    </div>
                </s:if>
                <s:elseif test="#session.user.role == 'admin'">
                    <img class="ui avatar image" src="avatars/${session.avatar}">
                    <i class="dropdown icon"></i>
                    <div class="menu">
                        <jsp:include page="logAdmin.jsp"/>
                    </div>
                </s:elseif>
                <s:else>
                    <img class="ui avatar image" src="avatars/${session.avatar}">
                    <i class="dropdown icon"></i>
                    <div class="menu">
                        <jsp:include page="logUser.jsp"/>
                    </div>
                </s:else>

            </div>
        </div>
    </div>
</div>


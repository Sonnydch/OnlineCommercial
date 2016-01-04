<%--
  Created by IntelliJ IDEA.
  User: Sonny
  Date: 2015/12/26
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="public/head.jsp"/>
</head>
<body>
<jsp:include page="public/nav.jsp"/>
<jsp:include page="public/register.jsp"/>
<jsp:include page="public/login.jsp"/>
<input hidden id = "user" name="user" value="${session.user.name}">
<div class="ui bottom attached segment pushable">
    <div class="ui left inverted vertical sidebar menu">
        <jsp:include page="public/sidebarMenu.jsp"/>
    </div>
    <div class="pusher">
        <div class="ui container center">
            <div class="ui three column grid centered">
                <div class="column">
                    <div class="ui basic segment">
                        <div class="ui people shape">
                        <div class="sides">
                            <s:iterator var="pic" value="pictureList" status="st">
                                <div class="side ${st.index==0?'active':''}">
                                <div class="ui card">
                                    <div class="image">
                                        <img src="images/${pic.dir}">
                                    </div>
                                </div>
                            </div>
                            </s:iterator>
                        </div>
                    </div>
                    </div>
                </div>
                <div class="column">
                    <div class="ui basic segment">
                        <div class="ui fluid card">
                            <div class="content">
                                <div class="header">商品名:${product.name}</div>
                            </div>
                            <div class="content">
                                <h4 class="ui sub header">类型:${product.type}</h4>
                                <h4 class="ui sub header">原价:${product.price}</h4>
                                <h4 class="ui sub header">积分会员价：${product.price*product.discount}</h4>
                                <div class="ui small feed">
                                    <div class="event">
                                        <div class="content">
                                            <div class="summary">
                                                <p>${product.description}</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="extra content">
                                <button class="ui button ${product.taken?"disabled":""}" onclick="goCart()">加入购物车</button>
                                <button class="ui button ${product.taken?"disabled":""}" onclick="goBuy()">马上购买</button>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="ten wide column">
                        <div class="ui comments">
                            <h3 class="ui dividing header">留言板</h3>
                            <s:iterator value="commentList" var="com">
                                <div class="comment">
                                    <a class="avatar">
                                        <img src="avatars/${com.avatar}">
                                    </a>
                                    <div class="content">
                                        <a class="author">${com.owner}</a>
                                        <div class="metadata">
                                            <span class="date">${com.createAt}</span>
                                        </div>
                                        <div class="text">
                                            ${com.content}
                                        </div>
                                    </div>
                                </div>
                            </s:iterator>
                            <form class="ui reply form" method="POST" action="detailInfo!addComment">
                                <input hidden name="productId" value="${product.id}">
                                <div class="field">
                                    <textarea name="content"></textarea>
                                </div>
                                <button type="submit" class="${session.user == null ?"disabled":""} ui blue labeled submit icon button">
                                    <i class="icon edit"></i> 留言
                                </button>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<script>
    $('.shape').shape();
    $(function(){
        function turnRight(){
            $('.shape').shape('flip right');
        }
        setInterval(turnRight,3000);
    });

    function goBuy(){
        var user = $("#user").val();
        if(!user){
            alert("请先登录!");
            return;
        }else{
            location.href = "orderItem!addOrderItem?productId=${product.id}";
        }
    }
    function goCart(){
        var user = $("#user").val();
        if(!user){
            alert("请先登录!");
            return;
        }else{
            location.href = "cart!addCartItem?productId=${product.id}";
        }
    }
</script>
<jsp:include page="public/footer.jsp"/>
</body>
</html>

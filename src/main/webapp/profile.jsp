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
        <div class="ui left inverted vertical sidebar menu">
            <jsp:include page="public/sidebarMenu.jsp"/>
        </div>
        <div class="pusher">
            <div class="ui container">
                <div class="ui orange center aligned segment">
                    <form class="ui form" action="profile!editProfile" method="post" enctype="multipart/form-data">
                    <input hidden name="profile.id" value="${profile.id}"/>
                    <input hidden name="profile.avatar" value="${session.avatar}"/>
                    <div class="ui header">个人资料</div>
                    <div class="inline field">
                        <label>账号</label>
                        <input type="text" disabled name="profile.userId" value="${session.user.id}"/>
                    </div>
                    <div class="inline field">
                        <label>积分</label>
                        <input type="text" disabled name="profile.coin" value="${profile.coin}"/>
                    </div>
                    <div class="inline field">
                        <label for="myFile">头像</label>
                        <img class="ui avatar image" id="myAvatar" src="avatars/${session.avatar}">
                        <input type="file" name="myFile" id="myFile"/>
                    </div>
                    <div class="inline field">
                        <label>用户</label>
                        <input type="text"  name="profile.name" value="${profile.name}"/>
                    </div>
                    <div class="inline field">
                        <label>邮箱</label>
                        <input type="text"  name="profile.email" value="${profile.email}"/>
                    </div>
                    <div class="inline field">
                        <label>地址</label>
                        <input type="text"  name="profile.address" value="${profile.address}"/>
                    </div>
                    <div class="inline field">
                        <label>手机</label>
                        <input type="text"  name="profile.mobile" value="${profile.mobile}"/>
                    </div>
                    <div class="inline field">
                        <label>电话</label>
                        <input type="text"  name="profile.tel" value="${profile.tel}"/>
                    </div>
                    <button type="submit" class="ui button inverted blue">提交</button>
                </form>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="public/footer.jsp"/>
</body>


<script>
    function handleFileSelect(evt) {
        var f = evt.target.files[0]; // FileList object
        // Only process image files.
        if (!f.type.match('image.*')) {
            alert("image only!");
            return;
        }
        var reader = new FileReader();
        // Closure to capture the file information.
        reader.onload = (function(theFile) {
            return function(e) {
                // Render thumbnail.
                document.getElementById('myAvatar').setAttribute("src",e.target.result);
            };
        })(f);
        // Read in the image file as a data URL.
        reader.readAsDataURL(f);
    }
    document.getElementById('myFile').addEventListener('change', handleFileSelect, false);
</script>
</html>

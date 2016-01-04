<%--
  Created by IntelliJ IDEA.
  User: Sonny
  Date: 2015/12/20
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--login modal--%>
<div class="ui modal log">
    <i class="close icon"></i>
    <div class="header">
        登录
    </div>
    <div class="image content">
        <div class="ui medium image">
            <img src="images/rachel.png">
        </div>
        <div class="description">
            <div class="ui form">
                <div class="ui header">用户登录</div>
                <div class="fields inline">
                    <div class="five wide field"><label>用户名：</label></div>
                    <div class="eleven wide field"><input  id="usernameLog" name="username" required="true" type="text"/></div>
                </div>
                <div class="fields inline">
                    <div class="five wide field"><label>密码：</label></div>
                    <div class="eleven wide field"><input id="passwordLog" name="password" required="true" type="password"/></div>
                </div>
                <button id="buttonLog" class="ui inverted green button">登录</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        $("#buttonLog").click (function(){
            var username =$("#usernameLog").val();
            var password =$("#passwordLog").val();
            if(!username){
                alert("用户名不能为空!");
                return;
            }
            if(!password){
                alert("密码不能为空!");
                return;
            }
            var user = {
                'user.name': username,
                'user.password': password
            };
            $.ajax({
                //这里的需要Struts.xml的<action/>的name属性一致。
                url:'login.action',
                //提交类型
                type:'POST',
                //提交数据给Action传入数据
                data: user,
                //返回的数据类型
                //成功调用的方法
                success:function(data){
                    //获取Action返回的数据用   data.Action中的属性名  获取
                    console.log(data);
                    if(data.result.result === true){
                        location.href = "index.jsp";
                    }else{
                        alert(data.result.message);
                    }
                },
                error:function(data){
                    console.log('error data',data);
                }
            });
        });
    });
    function removeThis(){
        $(this).parent().hide();
    }
    $(".menu .item.log").click(function(){
        $('.ui.modal.log').modal('show');
    });
</script>
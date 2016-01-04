<%--
  Created by IntelliJ IDEA.
  User: Sonny
  Date: 2015/12/20
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="ui modal reg">
    <i class="close icon"></i>
    <div class="header">
        注册
    </div>
    <div class="image content">
        <div class="ui medium image">
            <img src="images/rachel.png">
        </div>

        <div class="description">
                <div class="ui form">
                    <div class="ui header">用户注册</div>
                    <div class="fields inline">
                        <div class="five wide field"><label>用户名：</label></div>
                        <div class="eleven wide field"><input  name="username" id="usernameReg" required="true" type="text"/></div>
                    </div>
                    <div class="fields inline">
                        <div class="five wide field"><label>邮箱：</label></div>
                        <div class="eleven wide field"><input  name="useremail" id="useremailReg" required="true" type="text"/></div>
                    </div>
                    <div class="fields inline">
                        <div class="five wide field"><label>密码：</label></div>
                        <div class="eleven wide field"><input name="password" id="passwordReg" required="true" type="password"/></div>
                    </div>
                    <div class="fields inline">
                        <div class="five wide field"><label>重复密码：</label></div>
                        <div class="eleven wide field"><input name="confirm" id="confirmReg" required="true" type="password"/></div>
                    </div>
                    <div class="fields inline">
                        <div class="five wide field"><label>选择角色：</label></div>
                        <div class="eleven wide field">
                            <select name="role" id="role">
                                <option value="user">普通用户</option>
                                <option value="admin">管理员</option>
                            </select>
                        </div>
                    </div>
                    <button id="buttonReg" class="ui inverted green button">注册</button>
                </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        $("#buttonReg").click (function(){
            var username =$("#usernameReg").val();
            var password =$("#passwordReg").val();
            var email = $("#useremailReg").val();
            var confirm =$("#confirmReg").val();
            var role =$("#role").val();

            if(!username){
                alert("用户名不能为空!");
                return;
            }
            if(!password){
                alert("密码不能为空!");
                return;
            }
            if(!email){
                alert("邮箱不能为空!");
                return;
            }
            if(!validateEmail(email)){
                alert("邮箱格式不正确!");
                return;
            }
            if(password !== confirm){
                alert("密码两次输入不一致!");
                return;
            }
            var user = {
                'user.name': username,
                'user.password': password,
                'user.email': email,
                'user.role': role
            };
            $.ajax({
                //这里的需要Struts.xml的<action/>的name属性一致。
                url:'register.action',
                //提交类型
                type:'POST',
                //提交数据给Action传入数据
                data: user,
                //返回的数据类型
                //成功是调用的方法
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

    function validateEmail(email) {
        var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(email);
    }

    $(".menu .item.reg").click(function(){

        $('.ui.modal.reg').modal('show');
    })

</script>
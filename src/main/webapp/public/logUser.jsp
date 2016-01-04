<%--
  Created by IntelliJ IDEA.
  User: Sonny
  Date: 2015/12/27
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<a class="item" href="profile!myProfile"><i class="edit icon"></i>个人资料</a>
<a class="item" href="cart!listMyCart"><i class="in cart icon"></i>购物车</a>
<a class="item" href="addProduct.jsp"><i class="add to cart icon"></i>添加商品</a>
<a class="item" href="product!listMy"><i class="grid layout icon"></i>我添加的商品</a>
<a class="item" href="orderItem!listAllSeller"><i class="grid layout icon"></i>我的生意</a>
<a class="item" href="orderItem!listAllBuyer"><i class="columns icon"></i>我的订单</a>
<a class="item" href="comment!listMy"><i class="table icon"></i>我的评论</a>
<a class="item logout"><i class="power icon"></i>退出登录</a>



<script type="text/javascript">
    $(document).ready(function(){
        $(".item.logout").click (function(){
            $.ajax({
                //这里的需要Struts.xml的<action/>的name属性一致。
                url:'login!checkOut',
                //提交类型
                type:'GET',
                //成功调用的方法
                success:function(data){
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
</script>
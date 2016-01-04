<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Sonny
  Date: 2015/12/26
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="public/head.jsp"/>
    <title>add product</title>
    <style>
        .thumb {
            height: 75px;
            border: 1px solid #000;
            margin: 10px 5px 0 0;
        }
    </style>
</head>
<body>
<jsp:include page="public/nav2.jsp"/>
<div class="ui container">
    <div class="ui red center aligned segment">
        <form class="ui form" method="POST" action="product" enctype="multipart/form-data">
            <input hidden name="product.owner" value="${session.user.id}"/>
            <input hidden name="product.id" value="${product.id}"/>
            <input hidden name="product.cover" value="${product.cover}"/>
            <div class="ui header">商品信息</div>
            <div class="fields inline">
               <div class="three wide field"><label>名称</label></div>
                <div class="eleven wide field"><input name="product.name" type="text" required value="${product.name}"/></div>
            </div>
            <div class="fields inline">
                <div class="three wide field"><label>类型</label></div>
                <div class="eleven wide field"><select name="product.type" value="${product.type}">
                    <option value="other">其它</option>
                    <option value="nut">坚果</option>
                    <option value="cake">蛋糕</option>
                    <option value="beverage">饮料</option>
                    <option value="biscuit">饼干</option>
                    <option value="meat">肉类</option>
                    <option value="fruit">水果</option>
                    <option value="milk">奶粉</option>
                    <option value="help">护理</option>
                    <option value="medicine">药品</option>
                    <option value="plus">补品</option>
                    <option value="food">食品</option>
                    <option value="entertain">娱乐</option>
                    <option value="man">男装</option>
                    <option value="women">女装</option>
                    <option value="child">童装</option>
                    <option value="cow">牛仔</option>
                    <option value="jacket">夹克</option>
                    <option value="shoes">鞋子</option>
                    <option value="watch">手表</option>
                </select></div>
            </div>
            <div class="fields inline">
                <div class="three wide field"><label>图片</label></div>
                <div class="eleven wide field"><input type="file" id="files" name="files" multiple="multiple" /></div>
            </div>
            <div class="field inline">
                <s:iterator value="pictureList" var="pic">
                    <img class="thumb" src="images/${pic.dir}">
                    <a class="ui button" href="picture!delete?pictureId=${pic.id}&productId=${product.id}">删除</a>
                </s:iterator>
                <output id="list"></output>
            </div>
            <div class="fields inline">
                <div class="three wide field"><label>价格</label></div>
                <div class="eleven wide field"><input name="product.price" type="text" required value="${product.price}"/></div>
            </div>
            <div class="fields inline">
                <div class="three wide field"><label>折扣</label></div>
                <div class="eleven wide field"><input name="product.discount" type="text"  value="${product.discount}"/></div>
            </div>
            <div class="fields inline">
                <div class="three wide field"><label>商品描述</label></div>
                <div class="eleven wide field"><textarea name="product.description" required >${product.description}</textarea></div>
            </div>
            <button class="ui button green inverted" type="submit">确认</button>
        </form>
    </div>
</div>


<script>
    function handleFileSelect(evt) {
        var files = evt.target.files; // FileList object

        // Loop through the FileList and render image files as thumbnails.
        for (var i = 0, f; f = files[i]; i++) {

            // Only process image files.
            if (!f.type.match('image.*')) {
                continue;
            }

            var reader = new FileReader();

            // Closure to capture the file information.
            reader.onload = (function(theFile) {
                return function(e) {
                    // Render thumbnail.
                    var span = document.createElement('span');
                    span.innerHTML = ['<img class="thumb" src="', e.target.result,
                        '" title="', escape(theFile.name), '"/>'].join('');
                    document.getElementById('list').insertBefore(span, null);
                };
            })(f);

            // Read in the image file as a data URL.
            reader.readAsDataURL(f);
        }
    }

    document.getElementById('files').addEventListener('change', handleFileSelect, false);
</script>

</body>
</html>

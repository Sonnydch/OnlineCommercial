<%--
  Created by IntelliJ IDEA.
  User: Sonny
  Date: 2015/12/21
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>

    $('.ui.accordion') .accordion();

    $('.ui.sidebar')
            .sidebar({
                context: $('.bottom.segment')
            })
            .sidebar('attach events', '.menu .item.left')
    ;

</script>
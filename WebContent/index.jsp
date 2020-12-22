<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath%>">
<script src="js/jquery-1.12.4.js"></script>
<script>
$(function() {
	var username='${user.userName}';
	//alert(username);
	if(username==''){
		alert("你还没登录，请先登录")
		window.location.href="Login.jsp"
	}
	})
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>CRM系统--主页</title>
</head>
<style type="text/css">

    #head{
        height: 25px;
    }
    #leftmenu{
        width: 15%;
        background-color: beige;
        height: 600px;
        float: left;
    }
    #rightview{
        width: 85%;
        background-color: cornsilk;
        height: 600px;
        float: left;
    }
    span{ text-align:right;
    display:block;
    float:right;
    }
</style>
<body>
    <div id="head">
       欢迎【${sessionScope.user.userName }】登录 
       <span><a href="UserServlet?method=quit" onclick="return confirm('确认退出吗？')">安全退出</a></span>
    </div>

    <div id="leftmenu">
        <ul><a href="#">普通用户管理</a></ul>
        <ul><a href="#">销售管理员管理</a></ul>
        <ul><a href="user//adduser.jsp" target="rightview">增加用户</a></ul>
        <ul><a href="ProductServlet?tag=query" target="rightview">商品管理</a></ul>
    </div>
    <div id="rightview">
        <iframe src="welcome.html" name="rightview" frameborder="1px" width="100%" height="600px"></iframe>
    </div>
</body>
</html>
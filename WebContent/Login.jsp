<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CRM系统--登录页</title>
</head>
<body>
<div>
    <form action="UserServlet" method="post">
    <input type="hidden" name="method" value="login"/>
        <table>
            <tr><td>邮箱：</td>
                <td><input type="text" name="email" id="email" maxlength="32"/></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password" id="password" maxlength="18"/></td>
            </tr>
            <tr>
                <td><input type="reset"  value="重置"/></td>
                <td><input type="submit"  value="登录"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
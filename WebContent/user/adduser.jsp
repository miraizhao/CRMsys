<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<script type="text/javascript">
function checkinfo(){
	var email= document.getElementById("email");
	var userName= document.getElementById("userName");
	var roleId= document.getElementById("roleId");
	if(email.value.length==0){
		alert("邮箱不能为空")
		email.focus();
		return false;
	}if(userName.value.length==0){
		alert("昵称不能为空")
		userName.focus();
		return false;
	}if(roleId.value.length==0){
		alert("角色不能为空")
		roleId.focus();
		return false;
	}
	return true
}
</script>
<body>
	<div>
		<form action="UserServlet" method="post" onsubmit="return checkinfo()">
			<input type="hidden" name="method" value="adduser" />
			<table>
				<tr>
					<td>邮箱：<span style="color: red">*</span></td>
					<td><input name="email" id="email" type="text" maxlength="32">
					</td>
				</tr>
				<tr>
					<td>昵称：<span style="color: red">*</span></td>
					<td><input name="userName" id="userName" type="text"
						maxlength="32"></td>
				</tr>
				<tr>
					<td>角色：<span style="color: red">*</span></td>
					<td><select name="roleId" id="roleId">
							<option></option>
							<option value="1">销售管理员</option>
							<option value="2">普通用户</option>
					</select></td>
				</tr>
				<tr>
					<td>状态：</td>
					<td><input type="radio" name="state" value="0"
						checked="checked">启用 <input type="radio" name="state"
						value="1">禁用</td>
				</tr>
				<tr>
					<td>备注：</td>
					<td><textarea name="remark"
							style="width: 220px; height: 80px;" maxlength="500"></textarea></td>
				</tr>

				<tr>
					<td><input type="reset" value="重置"></td>
					<td><input type="submit" value="提交"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
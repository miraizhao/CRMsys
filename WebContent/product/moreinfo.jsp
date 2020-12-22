<%@page import="com.links.bean.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Title</title>
<style type="text/css">
#result tr th, #result tr td {
	border: 1px solid;
}
</style>
</head>
<body>
	<div>
		<table>
			<tr>
				<td>商品名：</td>
				<td><input disabled="disabled" type="text" name="proName"
					id="proName" maxlength="50" value="${product.proName}"></td>
			</tr>
			<tr>
				<td>商品编号：</td>
				<td><input disabled="disabled" type="text" name="proCode"
					id="proCode" maxlength="12" value="${product.proCode}"></td>
			</tr>
			<tr>
				<td>商品商品尺寸：</td>
				<td><input disabled="disabled" type="text" name="proCode"
					id="proCode" maxlength="12" value="${product.proSize}"></td>
			</tr>
			<tr>
				<td>商品价格：</td>
				<td><input disabled="disabled" name="minPrice" id="minPrice"
					value="${product.price}"></td>
			</tr>
			<tr>
				<td>使用说明：</td>
				<td><textarea disabled="disabled">${product.proUse}</textarea>
				</td>
			</tr>
			<tr>
				<td>备注：</td>
				<td><textarea disabled="disabled">${product.remark}</textarea>
				</td>
			</tr>
			<tr>
				<td>所属类别：</td>
				<td><select disabled="disabled" name="typeId" id="typeId">
						<option value="">${product.productType.typename}</option>

				</select></td>
			</tr>
			<tr>
				<td><input type="button"
					onclick="javascript:window.history.go(-1)" value="返回"></td>
			</tr>
		</table>
	</div>
</body>
</html>
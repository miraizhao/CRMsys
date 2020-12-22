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
span {
	color:red;
}
</style>
<script>
	$(function() {
		var hiddentypeid = $("#hiddentypeid").val();
		$("#typeId").val(hiddentypeid)
	})
	
	function checkall(){
		var proName=$("#proName").val();
		var proCode=$("#proCode").val();
		var proSize=$("#proSize").val();
		var price=$("#price").val();
		var typeId=$("#typeId").val();
		if(proName==""){
			alert("商品名不能为空")
			$("#proName").focus();
			return false;
		}
		if(proCode==""){
			alert("商品编号不能为空")
			$("#proCode").focus();
			return false;
		}
		if(proSize==""){
			alert("商品尺寸不能为空")
			$("#proSize").focus();
			return false;
		}
		if(price==""){
			alert("商品价格不能为空")
			$("#price").focus();
			return false;
		}
		if(typeId==""){
			alert("商品类型不能为空")
			$("#typeId").focus();
			return false;
		}
		
		
		var ret= /^[0-9a-zA-Z]{12}$/g;
		if(ret.test(proCode)){
		}else{
			alert("商品编号只能为数字或字母且必须为12位")
			$("#proCode").focus();
			return false;
		}
		
		return true;
	}
	
	function checkCode(code){
		if(code==$("#proCode").attr("oldvalue")){
			return;
		}
		if($.trim(code)!=""){
			$.get("ProductServlet",{
				proCode:code,
				tag:'checkcode'
			},function(data){
				if(data=='true'){
					alert("商品编号可用")
				}else{
					alert("商品编号不可用")
				}
			});
		}
		
	}
	
	
</script>
</head>
<body>

	<div>
		<form action="ProductServlet" method="post" >
			<input type="hidden" name="tag" value="modify"> <input
				type="hidden" name="id" id="id" value="${product.id}">
			<table>
				<tr>
					<td>商品名：<span>*</span></td>
					<td><input type="text" name="proName" id="proName"
						maxlength="50" value="${product.proName}"></td>
				</tr>
				<tr>
					<td>商品编号：<span>*</span></td>
					<td><input onkeyup="this.value=this.value.replace(/[^0-9a-zA-Z]*$/g,'')"
					type="text" name="proCode" id="proCode"
					onchange="return checkCode(this.value)"
						maxlength="12" value="${product.proCode}" oldvalue="${product.proCode}"
						>
						</td>
						
				</tr>
				<tr>
					<td>商品商品尺寸：<span>*</span></td>
					<td><input type="text" name="proSize" id="proSize"
						maxlength="12" value="${product.proSize}"></td>
				</tr>
				<tr>
					<td>商品价格：<span>*</span></td>
					<td><input name="price" id="price" value="${product.price}"></td>
				</tr>
				<tr>
					<td>使用说明：</td>
					<td><textarea name="proUse" id="proUse">${product.proUse}</textarea></td>
				</tr>
				<tr>
					<td>备注：</td>
					<td><textarea id="remark" name="remark">${product.remark}</textarea></td>
				</tr>
				<tr>
					<td>所属类别：<span>*</span></td>
					<td><select name="typeId" id="typeId">
							<option value="">--全部类别--</option>
							<%-- <option id="typeid" value="${product.productType.id }">${product.productType.typename}</option> --%>
							<c:forEach items="${productTypeList }" var="item">
								<option value="${item.id }">${item.typename}</option>
							</c:forEach>
					</select> <input type="hidden" value="${product.productType.id}"
						id="hiddentypeid"></td>
				</tr>
				<tr>
					<td><input onclick="javascript:window.history.go(-1)"
						type="button" value="返回"></td>
					<td><input type="submit" value="保存" onclick="return checkall()"></td>
				</tr>

			</table>
		</form>

	</div>
	<div>
		<!--//分页-->
	</div>
</body>
</html>
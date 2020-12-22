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
<script>
	function oncheck() {
		/* var minPrice = document.getElementById("minPrice").value; */
		/* var maxPrice = document.getElementById("maxPrice").value; */
		var minPrice=$("#minPrice").val();
		var maxPrice=$("#maxPrice").val();
		if (minPrice != "" && maxPrice != "") {
			if (parseFloat(minPrice) > parseFloat(maxPrice)) {
				alert("价格区间不正确，最大值应该大于最小值");
				$("#minPrice").focus();
				return false;
			}
		}
		return true;
	}
	
	function del(tepid,obj,name){
		if(confirm('是否确认删除【'+name+'】吗？')){
			$.get("ProductServlet",{
				id:tepid,
				tag:'delajax'
			},function(data){
				if(data=='true'){
					alert("删除成功")
					//再次查询实现刷新
					window.location.reload();
					//window.location.href='ProductServlet?tag=query';
					//使用js代码静态移除
					$(obj).parent().parent().remove();
					//刷新总和(还有序号也需要更新)
					// $("#rows").html($("#rows").html()-1);
				}else{
					alert("删除失败")
				}
			});
		}else{
			return false;
		}
		
	}
</script>
<title>Title</title>
<style type="text/css">
#result tr th, #result tr td {
	border: 1px solid;
}
</style>
</head>
<body >
	<div>
		<!--//查询条件-->
		<form action="ProductServlet" method="post"
			onsubmit="return oncheck()">
			<input id="tag" name="tag" value="query" type="hidden">
			<table>
				<tr>
					<td>商品名：</td>
					<td><input type="text" name="proName" id="proName"
						maxlength="50"></td>
				</tr>
				<tr>
					<td>商品编号：</td>
					<td><input type="text" name="proCode" id="proCode"
						maxlength="12"></td>

				</tr>
				<tr>
					<td>商品价格范围：</td>
					<td><input type="number" name="minPrice" id="minPrice"
						value="">~ <input type="number" name="maxPrice"
						id="maxPrice" value=""></td>

				</tr>
				<tr>
					<td>所属类别：</td>
					<td><select name="typeId" id="typeId">
							<option value="">全部类别</option>
							<c:forEach items="${productTypeList }" var="item"
								varStatus="status">
								<option value="${item.id }">${item.typename }</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="查询"></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<!--//查询的结果-->
		<table id="result" cellpadding="0" cellspacing="0" style="width: 100%;min-width: 100%">
			<thead>
				<tr>
					<th width="5%">序号</th>
					<th width="10%">商品名称</th>
					<th width="10%">商品编号</th>
					<th width="10%">商品尺寸</th>
					<th width="10%">价格</th>
					<th width="20%">商品说明</th>
					<th width="10%">所属类别</th>
					<th width="20%">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="item" varStatus="status">
					<tr>
						<td>${status.count }</td>
						<td>${item.proName }</td>
						<td>${item.proCode }</td>
						<td>${item.proSize }</td>
					
						<td style="text-align: right">${item.price }</td>
						<td style="text-align: center">${item.proUse }</td>
						<td>${item.productType.typename }</td>
						<td style="text-align: center"><a
							href="ProductServlet?action=qu&tag=info&id=${item.id }">查看详情
						</a> <a href="ProductServlet?action=mo&tag=info&id=${item.id }">编辑
						</a> <a href="ProductServlet?tag=del&id=${item.id }"
							onclick="return confirm('是否确认删除')">删除</a>
							<a href="javascript:void(0)" onclick="del('${item.id}',this,'${item.proName }')">删除ajax</a></td>
				 
				 <%-- <button onclick="del('${item.id}')" >删除ajax</button></td> --%>
				 
				
				 </tr>
				</c:forEach>
				<%-- 
				<%
				List<Product> productlist=(List<Product>)request.getAttribute("products");
				int i=1;
				for(Product p:productlist){
					%>
					<tr>
					<td><%=i %></td>
					<td><%=p.getProName() %></td>
					<td><%=p.getProCode() %></td>
					<td><%=p.getProSize() %></td>
					<td><%=p.getPrice() %></td>
					<td><%=p.getProUse() %></td>
					<td><%=p.getProductType().getTypename() %></td>
					<td>
					<a href="#">查看详情 </a> 
					<a href="#">编辑 </a> 
					<a href="#">删除</a>
					</td>
				</tr>
				<%
				i++;
				}
				%> 
			 --%>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="8">共计： <span id="rows">${products.size()}</span>条记录</td>
				</tr>
			</tfoot>
		</table>
	</div>
	<div>
		<!--//分页-->
	</div>
</body>
</html>
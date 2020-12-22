package com.links.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.links.bean.Product;
import com.links.bean.ProductType;
import com.links.service.ProductService;
import com.links.service.ProductTypeService;
import com.links.service.impl.ProductServiceImpl;
import com.links.service.impl.ProductTypeServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	ProductTypeService productTypeService = new ProductTypeServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		//从前端得到参数设置条件
		String tag = request.getParameter("tag");
		switch (tag) {
		case "query":
			queryProducts(request, response);
			break;
		case "info":
			moreinfo(request, response);
			break;
		case "modify":
			modify(request, response);
			break;
		case "del":
			del(request, response);
			break;
		case "checkcode":
			checkCode(request, response);
			break;
			
		case "delajax":
			delajax(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void queryProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Product product = new Product();
		if (request.getParameter("minPrice")!=null&&request.getParameter("minPrice").length()>0) {
			float minPrice = Float.parseFloat(request.getParameter("minPrice"));
			product.setMinPrice(minPrice);
		}
		if (request.getParameter("maxPrice")!=null&&request.getParameter("maxPrice").length()>0) {
			float maxPrice = Float.parseFloat(request.getParameter("maxPrice"));
			product.setMaxPrice(maxPrice);
		}
		if (request.getParameter("proName")!=null&&!request.getParameter("proName").isEmpty()) {
			String proName = request.getParameter("proName");
			product.setProName(proName);
		}
		if (request.getParameter("proCode")!=null&&!request.getParameter("proCode").isEmpty()) {
			String proCode = request.getParameter("proCode");
			product.setProCode(proCode);
		}
		if (request.getParameter("typeId")!=null&&!request.getParameter("typeId").isEmpty()) {
			String typeId = request.getParameter("typeId");
			product.setTypeId(typeId);
		}
		//根据条件查询商品
		List<Product> products = productService.findProductAVG(product);
		request.setAttribute("products", products);
		// 得到商品类别
		List<ProductType> productTypeList = productTypeService.getProductTypeList(null);
		request.setAttribute("productTypeList", productTypeList);
		request.getRequestDispatcher("product/productlist.jsp").forward(request, response);
	}
	
	
	protected void moreinfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		String action = request.getParameter("action");
		//根据条件查询商品
		Product product = productService.findProductById(id);
		request.setAttribute("product", product);
		// 得到商品类别
		List<ProductType> productTypeList = productTypeService.getProductTypeList(null);
		request.setAttribute("productTypeList", productTypeList);
		switch (action) {
		case "qu":
			request.getRequestDispatcher("product/moreinfo.jsp").forward(request, response);
			break;
		case "mo":
			request.getRequestDispatcher("product/modify.jsp").forward(request, response);
			break;
			
		
			
		default:
			break;
		}
		
	}
	
	
	protected void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Product product = new Product();
		if (request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()) {
			String id = request.getParameter("id");
			product.setId(id);
		}
		if (request.getParameter("proName")!=null&&!request.getParameter("proName").isEmpty()) {
			String proName = request.getParameter("proName");
			product.setProName(proName);
		}
		if (request.getParameter("proCode")!=null&&!request.getParameter("proCode").isEmpty()) {
			String proCode = request.getParameter("proCode");
			product.setProCode(proCode);
		}
		if (request.getParameter("proSize")!=null&&!request.getParameter("proSize").isEmpty()) {
			String proSize = request.getParameter("proSize");
			product.setProSize(proSize);
		}
		if (request.getParameter("price")!=null&&!request.getParameter("price").isEmpty()) {
			float price = Float.parseFloat(request.getParameter("price"));
			product.setPrice(price);
		}
		if (request.getParameter("proUse")!=null&&!request.getParameter("proUse").isEmpty()) {
			String proUse = request.getParameter("proUse");
			product.setProUse(proUse);
		}
		if (request.getParameter("remark")!=null&&!request.getParameter("remark").isEmpty()) {
			String remark = request.getParameter("remark");
			product.setRemark(remark);
		}
		if (request.getParameter("typeId")!=null&&!request.getParameter("typeId").isEmpty()) {
			String typeId = request.getParameter("typeId");
			product.setTypeId(typeId);
		}
		boolean re = productService.updateProduct(product);
		if (re) {
			request.setAttribute("info", "修改成功。");
			request.getRequestDispatcher("info.jsp").forward(request, response);
			
		} else {
			request.setAttribute("info", "修改失败。");
			request.getRequestDispatcher("info.jsp").forward(request, response);
		}
	}
	protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id=request.getParameter("id");
		boolean re = productService.changeProductStat(id, 0);
		if (re) {
//			request.setAttribute("info", "删除成功");
//			request.getRequestDispatcher("info.jsp").forward(request, response);
			response.getWriter().print("<script>alert('删除成功');window.location.href='ProductServlet?tag=query';</script>");
		}else {
			request.setAttribute("info", "删除失败");
			request.getRequestDispatcher("info.jsp").forward(request, response);
		}
	}
	
	protected void checkCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String proCode=request.getParameter("proCode");
		if(productService.checkCodeRe(proCode)){
			response.getWriter().print("error");
		}else {
			response.getWriter().print("true");
		}
		
	}
	protected void delajax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id=request.getParameter("id");
		boolean re = productService.changeProductStat(id, 0);
		if (re) {
			response.getWriter().print("true");
		}else {
			response.getWriter().print("error");
		}
	}
	
	
}

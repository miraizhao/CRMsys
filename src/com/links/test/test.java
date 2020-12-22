package com.links.test;



import java.util.List;

import org.junit.Test;
import com.links.bean.Product;
import com.links.bean.User;
import com.links.dao.GoodsDao;
import com.links.dao.impl.GoodsDaoImpl;
import com.links.service.GoodsService;
import com.links.service.ProductService;
import com.links.service.UserService;
import com.links.service.impl.GoodsServiceImpl;
import com.links.service.impl.ProductServiceImpl;
import com.links.service.impl.UserServiceImpl;

public class test {
	UserService userService=new UserServiceImpl();
	GoodsService goodsservice=new GoodsServiceImpl();
	GoodsDao goodsd=new GoodsDaoImpl();
	ProductService prod=new ProductServiceImpl();
	@Test
	public void testcheckemail() {
		System.out.println(userService.checkEmail("123"));
	}
	
	@Test
	public void checkLogin(){
		User user=userService.checkLogin("admin", "123456");
		System.out.println(user);
	}
	
	@Test
	public void testadduser(){
		User user=new User(null, "test2", "测试", "123456", 1, 1, null, "");
		userService.addUser(user);
	}
	
	@Test
	public void  testfindprolist(){
		List<Product> findProductAVG = prod.findProductAVG(null);
		for (Product product : findProductAVG) {
			System.out.println(product);
		}
	}
	
	@Test
	public void test1(){
		Product pr=new Product();
//		pr.setMinPrice(900000);
		pr.setMaxPrice(100);
//		pr.setTypeId("T006");
		List<Product> products =prod.findProductAVG(pr);
		for (Product p : products) {
			System.out.println(p);
		}
	}
	@Test
	public void test2(){
	
	Product findProductById = prod.findProductById("A001");
		System.out.println(findProductById);
	}
}

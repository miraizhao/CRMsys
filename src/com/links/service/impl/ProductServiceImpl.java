package com.links.service.impl;

import java.util.List;

import com.links.bean.Product;
import com.links.dao.ProductDao;
import com.links.dao.impl.ProductDaoImpl;
import com.links.service.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDao dao;
	public ProductServiceImpl(){
		dao=new ProductDaoImpl();
	}
	@Override
	public List<Product> findProductByVAGname(String VAGname) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 添加商品
	 */
	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return dao.addProduct(product);
	}

	@Override
	public Product findProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeProductStat(String id, int state) {
		// TODO Auto-generated method stub
		return dao.changeProductStat(id, state);
	}

	@Override
	public List<Product> listAllProduct() {
		// TODO Auto-generated method stub
		return dao.listAllProduct();
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return dao.updateProduct(product);
	}

	@Override
	public Product findProductById(String id) {
		// TODO Auto-generated method stub
		return dao.findProductById(id);
	}
	@Override
	public List<Product> findProductAVG(Product product) {
		// TODO Auto-generated method stub
		return dao.findProductAVG(product);
	}
	@Override
	public boolean checkCodeRe(String proCode) {
		// TODO Auto-generated method stub
		return dao.checkCodeRe(proCode);
	}

}

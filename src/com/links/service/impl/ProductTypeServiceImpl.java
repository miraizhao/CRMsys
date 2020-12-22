package com.links.service.impl;

import java.util.List;

import com.links.bean.ProductType;
import com.links.dao.ProductTypeDao;
import com.links.dao.impl.ProductTypeDaoImpl;
import com.links.service.ProductTypeService;

public class ProductTypeServiceImpl implements ProductTypeService{
	ProductTypeDao dao;
	public ProductTypeServiceImpl(){
		dao=new ProductTypeDaoImpl();
	}
	@Override
	public boolean createProductType(ProductType productType) {
		// TODO Auto-generated method stub
		return dao.createProductType(productType);
	}

	@Override
	public boolean deleteProductType(String id) {
		// TODO Auto-generated method stub
		return dao.deleteProductType(id);
	}

	@Override
	public boolean updateProductType(ProductType productType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProductType> getProductTypeList(ProductType productType) {
		// TODO Auto-generated method stub
		return dao.getProductTypeList(productType);
	}

	@Override
	public ProductType getProductTypeById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.links.service;

import java.util.List;

import com.links.bean.ProductType;

public interface ProductTypeService {
	boolean createProductType(ProductType productType);
	boolean deleteProductType(String id);
	boolean updateProductType(ProductType productType);
	List<ProductType> getProductTypeList(ProductType productType);
	ProductType getProductTypeById(String id);
}

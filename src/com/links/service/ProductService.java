package com.links.service;

import java.util.List;

import com.links.bean.Product;

public interface ProductService {
	List<Product> findProductByVAGname(String VAGname);

	boolean addProduct(Product product);

	Product findProductByName(String name);

	boolean changeProductStat(String id, int state);

	List<Product> listAllProduct();

	boolean updateProduct(Product product);

	Product findProductById(String id);
	List<Product> findProductAVG(Product product);
	boolean checkCodeRe(String proCode);
}

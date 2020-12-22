package com.links.dao;

import java.util.List;

import com.links.bean.Goods;

public interface GoodsDao {
	List<Goods> findGoodsByVAGname(String VAGname);

	boolean addGoods(Goods goods);

	Goods findGoodsByName(String name);

	boolean changeGoodsStat(String id, int state);

	List<Goods> listAllGoods();

	boolean updateGoods(Goods goods);

	Goods findGoodsById(String id);
}

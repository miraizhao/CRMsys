package com.links.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.links.bean.Goods;
import com.links.dao.GoodsDao;

import com.links.dao.impl.GoodsDaoImpl;
import com.links.service.GoodsService;
import com.links.util.KeyboardIn;
import com.links.util.UUIDUtil;

public class GoodsServiceImpl implements GoodsService {
	GoodsDao goodsdao = new GoodsDaoImpl();
	/**
	 * 根据名字模糊查询商品
	 * 返回商品列表
	 */
	@Override
	public void findGoodsByVAGname(String VAGname) {
		List<Goods> issalelist = new ArrayList<Goods>();
		List<Goods> unsalelist = new ArrayList<Goods>();
		List<Goods> goodslist = goodsdao.findGoodsByVAGname(VAGname);
		for (Goods goods : goodslist) {
			if (goods.getGoodsState() == 0) {
				issalelist.add(goods);
			} else {
				unsalelist.add(goods);
			}
		}if (issalelist.isEmpty()&&unsalelist.isEmpty()) {
			System.out.println("没有查到商品");
		}else if (issalelist.isEmpty()) {
			System.out.println("没有在售商品\n");
			System.out.println("下架商品列表");
			for (Goods goods : unsalelist) {
				System.out.println("商品编号:" + goods.getGoodsID() + "   商品名称:" + goods.getGoodsName() + "   商品价格:"
						+ goods.getGoodsPrice() + "   商品数量:" + goods.getGoodsAmount());
			}
		}else if (unsalelist.isEmpty()) {
			System.out.println("没有下架商品\n");
			System.out.println("在售商品列表");
			for (Goods goods : issalelist) {
				System.out.println("商品编号:" + goods.getGoodsID() + "   商品名称:" + goods.getGoodsName() + "   商品价格:"
						+ goods.getGoodsPrice() + "   商品数量:" + goods.getGoodsAmount());
			}
		}else {
			System.out.println("在售商品列表");
			for (Goods goods : issalelist) {
				System.out.println("商品编号:" + goods.getGoodsID() + "   商品名称:" + goods.getGoodsName() + "   商品价格:"
						+ goods.getGoodsPrice() + "   商品数量:" + goods.getGoodsAmount());
			}
			System.out.println("下架商品列表");
			for (Goods goods : unsalelist) {
				System.out.println("商品编号:" + goods.getGoodsID() + "   商品名称:" + goods.getGoodsName() + "   商品价格:"
						+ goods.getGoodsPrice() + "   商品数量:" + goods.getGoodsAmount());
			}
		}
		
	}
	/**
	 * 新增商品
	 */
	@Override
	public void addGoods() {
		// TODO Auto-generated method stub
		Goods goods = new Goods();
		boolean rs=false;
		System.out.println("请输入商品的名称");
		String tempname = KeyboardIn.InPut();
		Goods checkgoods = goodsdao.findGoodsByName(tempname);
		if (checkgoods != null) {
			System.out.println("商品名已经存在");
			if (checkgoods.getGoodsState() == 1) {
				System.out.println("该商品已下架，是否上架该商品");
				// TODO 上架商品
				System.out.println("1.上架该商品 2.不上架该商品");
				String key = KeyboardIn.InPut();
				switch (key) {
				case "1":
					checkgoods.setGoodsState(0);
					break;
				case "2":
					System.out.println("添加失败");
					return;

				default:
					break;
				}
			}
			System.out.println("请输入商品数量");
			int tempamount = KeyboardIn.INTInPut();
			checkgoods.setGoodsAmount(tempamount);
			 rs = goodsdao.updateGoods(checkgoods);
			if (rs) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
		} else {
			System.out.println("请输入该商品的价格");
			float tempprice = KeyboardIn.floatInPut();
			goods.setGoodsPrice(tempprice);
			System.out.println("请输入商品的数量");
			int tempamount = KeyboardIn.INTInPut();
			goods.setGoodsAmount(tempamount);

			goods.setGoodsID(UUIDUtil.getUUID());
			goods.setGoodsName(tempname);

			goods.setGoodsInfol(null);
			goods.setGoodsState(0);
			// TODO 是否确定存入
			 rs = goodsdao.addGoods(goods);
			if (rs) {
				System.out.println("添加成功");
			} else {
				System.out.println("添加失败");
			}
		}
	}

	@Override
	public void changeGoodsStat() {
		// TODO Auto-generated method stub
		listISsaleGoods();
		System.out.println("请输入下架商品的编号");
		String tempid = KeyboardIn.InPut();
		// TODO 判断下架商品id的商品是否存在！！
		boolean re = goodsdao.changeGoodsStat(tempid, 1);
		if (re) {
			System.out.println("下架成功");
		} else {
			System.out.println("下架失败");
		}
	}

	@Override
	public void listISsaleGoods() {
		// TODO Auto-generated method stub
		List<Goods> issalelist = new ArrayList<Goods>();
		List<Goods> goodslist = goodsdao.listAllGoods();
		for (Goods goods : goodslist) {
			if (goods.getGoodsState() == 0) {
				issalelist.add(goods);
			}
		}
		System.out.println("在售商品列表");
		for (Goods goods : issalelist) {
			System.out.println("商品编号:" + goods.getGoodsID() + "   商品名称:" + goods.getGoodsName() + "   商品价格:"
					+ goods.getGoodsPrice() + "   商品数量:" + goods.getGoodsAmount());
		}
	}

	@Override
	public void updateGoods() {
		// TODO Auto-generated method stub
		Goods tempgoods = new Goods();

		listAllGoods();
		System.out.println("请输入修改商品的编号");
		String tempid = KeyboardIn.InPut();
		tempgoods = goodsdao.findGoodsById(tempid);
		if (tempgoods == null) {
			System.out.println("您输入的编号不存在");
		} else {
			System.out.println("请输入修改后的商品名");
			String upname = KeyboardIn.InPut();
			System.out.println("请输入修改后的商品价格");
			float upprice = KeyboardIn.floatInPut();
			System.out.println("请输入修改后的商品数量");
			Integer upamount = KeyboardIn.INTInPut();
			tempgoods.setGoodsName(upname);
			tempgoods.setGoodsPrice(upprice);
			tempgoods.setGoodsAmount(upamount);
			tempgoods.setGoodsState(0);// 修改后默认上架
			boolean re = goodsdao.updateGoods(tempgoods);
			if (re) {
				System.out.println("修改成功");
			} else {
				System.err.println("修改失败");
			}
		}
	}

	@Override
	public void listAllGoods() {
		List<Goods> issalelist = new ArrayList<Goods>();
		List<Goods> unsalelist = new ArrayList<Goods>();
		List<Goods> goodslist = goodsdao.listAllGoods();
		for (Goods goods : goodslist) {
			if (goods.getGoodsState() == 0) {
				issalelist.add(goods);
			} else {
				unsalelist.add(goods);
			}
		}
		System.out.println("在售商品列表");
		for (Goods goods : issalelist) {
			System.out.println("商品编号:" + goods.getGoodsID() + "   商品名称:" + goods.getGoodsName() + "   商品价格:"
					+ goods.getGoodsPrice() + "   商品数量:" + goods.getGoodsAmount());
		}
		System.out.println("下架商品列表");
		for (Goods goods : unsalelist) {
			System.out.println("商品编号:" + goods.getGoodsID() + "   商品名称:" + goods.getGoodsName() + "   商品价格:"
					+ goods.getGoodsPrice() + "   商品数量:" + goods.getGoodsAmount());
		}
	}

}

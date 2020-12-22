package com.links.bean;

public class Goods {
	private String goodsID;
	private String goodsName;
	private float goodsPrice;
	private Integer goodsAmount;
	private String goodsInfol;
	private Integer goodsState;
	
	public Goods() {
		super();
	}

	public Goods(String goodsID, String goodsName, float goodsPrice, Integer goodsAmount, String goodsInfol,
			Integer goodsState) {
		super();
		this.goodsID = goodsID;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsAmount = goodsAmount;
		this.goodsInfol = goodsInfol;
		this.goodsState = goodsState;
	}

	public String getGoodsID() {
		return goodsID;
	}

	public void setGoodsID(String goodsID) {
		this.goodsID = goodsID;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public float getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(Integer goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public String getGoodsInfol() {
		return goodsInfol;
	}

	public void setGoodsInfol(String goodsInfol) {
		this.goodsInfol = goodsInfol;
	}

	public Integer getGoodsState() {
		return goodsState;
	}

	public void setGoodsState(Integer goodsState) {
		this.goodsState = goodsState;
	}

//	@Override
//	public String toString() {
//		return "Goods [goodsID=" + goodsID + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice
//				+ ", goodsAmount=" + goodsAmount + ", goodsInfol=" + goodsInfol + ", goodsState=" + goodsState + "]";
//	}
//	
	
	
}

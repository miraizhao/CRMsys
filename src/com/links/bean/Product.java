package com.links.bean;

public class Product {
	private String id;
	private String proName;
	private String proCode;
	private String proSize;
	private float price;
	private String proUse;
	private String remark;
	private String typeId;
	private Integer state;
	private float maxPrice;
	private float minPrice;
	private ProductType productType;
	public Product(){
		
	}
	
	public Product(String id, String proName, String proCode, String proSize, float price, String typeId, Integer state, ProductType productType) {
		super();
		this.id = id;
		this.proName = proName;
		this.proCode = proCode;
		this.proSize = proSize;
		this.price = price;
		this.typeId = typeId;
		this.state = state;
		this.productType = productType;
	}
	public Product(String id, String proName, String proCode, String proSize, float price, String proUse, String remark,
			String typeId, Integer state) {
		super();
		this.id = id;
		this.proName = proName;
		this.proCode = proCode;
		this.proSize = proSize;
		this.price = price;
		this.proUse = proUse;
		this.remark = remark;
		this.typeId = typeId;
		this.state = state;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProCode() {
		return proCode;
	}
	public void setProCode(String proCode) {
		this.proCode = proCode;
	}
	public String getProSize() {
		return proSize;
	}
	public void setProSize(String proSize) {
		this.proSize = proSize;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getProUse() {
		return proUse;
	}
	public void setProUse(String proUse) {
		this.proUse = proUse;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", proName=" + proName + ", proCode=" + proCode + ", proSize=" + proSize
				+ ", price=" + price + ", proUse=" + proUse + ", remark=" + remark + ", typeId=" + typeId + ", state="
				+ state + ", maxPrice=" + maxPrice + ", minPrice=" + minPrice + ", productType=" + productType + "]";
	}

	
	
}

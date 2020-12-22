package com.links.bean;

public class ProductType {
	private String id;
	private String typename;
	private Integer state;
	public ProductType(){
		
	}
	public ProductType(String id, String typename, Integer state) {
		super();
		this.id = id;
		this.typename = typename;
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "ProductType [id=" + id + ", typename=" + typename + ", state=" + state + "]";
	}
	
}

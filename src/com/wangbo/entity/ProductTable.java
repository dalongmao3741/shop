package com.wangbo.entity;

public class ProductTable {
	private int s_id;
	private String s_name;
	private int a_nums;
	private double price;
	private String a_unit;
	
	public ProductTable() {
		super();
	}
	public ProductTable(int s_id, String s_name, int a_nums, double price,
			String a_unit) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.a_nums = a_nums;
		this.price = price;
		this.a_unit = a_unit;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getA_nums() {
		return a_nums;
	}
	public void setA_nums(int a_nums) {
		this.a_nums = a_nums;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getA_unit() {
		return a_unit;
	}
	public void setA_unit(String a_unit) {
		this.a_unit = a_unit;
	}
	

}

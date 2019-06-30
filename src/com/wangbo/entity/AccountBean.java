package com.wangbo.entity;

 
import java.io.Serializable;
import java.sql.Date;

public class AccountBean implements Serializable{
	private int a_id;
	private String a_name;
	private int a_nums;
	private double a_amount;
	private String a_unit;

	private int a_ispayed;
	private String s_name;
	private String a_Info;
	private String a_Date;
	
	
	@Override
	public String toString() {
		return "AccountBean [a_id=" + a_id + ", a_name=" + a_name + ", a_nums="
				+ a_nums + ", a_amount=" + a_amount + ", a_unit=" + a_unit
				+ ", a_ispayed=" + a_ispayed + ", s_name=" + s_name
				+ ", a_Info=" + a_Info + ", a_Date=" + a_Date + "]";
	}
	public AccountBean() {
		super();
	}
	public AccountBean(int a_id, String a_name, int a_nums, double a_amount,
			String a_unit, int a_ispayed, String s_name,
			String a_Info, String a_Date) {
		super();
		this.a_id = a_id;
		this.a_name = a_name;
		this.a_nums = a_nums;
		this.a_amount = a_amount;
		this.a_unit = a_unit;
		this.a_ispayed = a_ispayed;
		this.s_name = s_name;
		this.a_Info = a_Info;
		this.a_Date = a_Date;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int aId) {
		a_id = aId;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String aName) {
		a_name = aName;
	}
	public int getA_nums() {
		return a_nums;
	}
	public void setA_nums(int aNums) {
		a_nums = aNums;
	}
	public double getA_amount() {
		return a_amount;
	}
	public void setA_amount(double aAmount) {
		a_amount = aAmount;
	}
	public int getA_ispayed() {
		return a_ispayed;
	}
	public void setA_ispayed(int aIspayed) {
		a_ispayed = aIspayed;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String sName) {
		s_name = sName;
	}

	
	public String getA_Info() {
		return a_Info;
	}
	public void setA_Info(String aInfo) {
		a_Info = aInfo;
	}
	public String getA_Date() {
		return a_Date;
	}
	public void setA_Date(String aDate) {
		a_Date = aDate;
	}
	public String getA_unit() {
		return a_unit;
	}
	public void setA_unit(String aUnit) {
		a_unit = aUnit;
	}

}

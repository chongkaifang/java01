package com.offcn.po;

public class Mobile {

	private int ID;
	//号码前缀
	private String MobileNumber;
	//号码归属地
	private String MobileArea;
	//供应商
	private String MobileType;
	private String AreaCode;
	private String PostCode;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getMobileArea() {
		return MobileArea;
	}
	public void setMobileArea(String mobileArea) {
		MobileArea = mobileArea;
	}
	public String getMobileType() {
		return MobileType;
	}
	public void setMobileType(String mobileType) {
		MobileType = mobileType;
	}
	public String getAreaCode() {
		return AreaCode;
	}
	public void setAreaCode(String areaCode) {
		AreaCode = areaCode;
	}
	public String getPostCode() {
		return PostCode;
	}
	public void setPostCode(String postCode) {
		PostCode = postCode;
	}
	public Mobile() {
		super();
	}
	public Mobile(int iD, String mobileNumber, String mobileArea, String mobileType, String areaCode, String postCode) {
		super();
		ID = iD;
		MobileNumber = mobileNumber;
		MobileArea = mobileArea;
		MobileType = mobileType;
		AreaCode = areaCode;
		PostCode = postCode;
	}
	
}

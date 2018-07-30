package com.ycj.pojo;

public class DataPackage {
	private String errorCode = "0";
	private String errorMsg = "";
	
	private String data = "";

	@Override
	public String toString() {
		return "{\"errorCode\":\"" + errorCode + "\",\"errorMsg\":\"" + errorMsg + "\",\"data\":\"" + data + "\"}";
	}

	public DataPackage() {
		super();
	}

	public DataPackage(String errorCode, String errorMsg, String data) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.data = data;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	

}

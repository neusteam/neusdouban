package com.ycj.pojo;

public class ErrorMessage {
	private String errorCode = "0";
	private String errorMsg = "null";
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
	@Override
	public String toString() {
		return "{\"errorCode\":\"" + errorCode + "\",\"errorMsg\":\"" + errorMsg + "\"}  ";
	}
}

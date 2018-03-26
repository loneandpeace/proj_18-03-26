package com.hw.consts;

public enum PaymentTypeEnum {
	
	ONLINE(1,"����֧��"),
	OFFLINE(2,"��������");
	
	
	private int type;
	private String msg;
	private PaymentTypeEnum(int type, String msg) {
		this.type = type;
		this.msg = msg;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}

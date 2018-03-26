package com.hw.consts;

public enum OrderStatusEnum {
	//0-��ȡ��   10-δ����    20-�Ѹ���    40-�ѷ���    50-���׳ɹ�    60-���׹ر�
	
	CANCEL(0,"�Ѿ�ȡ��"),
	UNPAY(10,"δ����"),
	PAY(20,"�Ѹ���"),
	SEND(40,"�ѷ���"),
	SUCCCESS(50,"���׳ɹ�"),
	CLOSE(60,"���׹ر�");
	
	
	private int status;
	private String message;
	
	private OrderStatusEnum(int status, String message) {
		this.status = status;
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}

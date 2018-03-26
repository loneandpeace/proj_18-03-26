package com.hw.entity;

public class CartPageVO {
	
	public static final int CART_SUCCESS=1;
	public static final int CART_FAIL=0;
	
	private int errorno;
	private String message;
	private PageModel<Cart> pageModel;
	
	public int getErrorno() {
		return errorno;
	}
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PageModel<Cart> getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel<Cart> pageModel) {
		this.pageModel = pageModel;
	}
	
	
}

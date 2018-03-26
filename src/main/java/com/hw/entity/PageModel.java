package com.hw.entity;

import java.io.Serializable;
import java.util.List;

public class PageModel<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2783105372381705967L;
	
	
	private List<T> data;
	private int totalCount;
	private int currentPage;
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPsge() {
		return currentPage;
	}
	public void setCurrentPsge(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "PageModel [data=" + data + ", totalCount=" + totalCount + ", currentPage=" + currentPage + "]";
	}
	
	
	
}

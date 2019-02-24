package com.crm.utils;

import java.util.List;

public class Page<T> {
    //总条数
	private int total;
	//当前页号
	private int page;
	//每一页的记录条数量
	private int size;
	//页面的数据显示，从数据库获得
    private List<T> rows;

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
	
    
}

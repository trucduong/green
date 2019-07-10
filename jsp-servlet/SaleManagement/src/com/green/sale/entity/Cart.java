package com.green.sale.entity;

import java.util.Date;

public class Cart {
	private int code;
	private int accountCode;
	private long total;
	private Date createdDate;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(int accountCode) {
		this.accountCode = accountCode;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}

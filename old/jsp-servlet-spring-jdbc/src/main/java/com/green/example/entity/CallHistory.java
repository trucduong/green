package com.green.example.entity;

import java.util.Date;

import utils.CallHistoryType;

public class CallHistory {
	private long id;

	private String phone;

	private Date calledAt;

	private CallHistoryType callType;

	private boolean readed;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCalledAt() {
		return calledAt;
	}

	public void setCalledAt(Date calledAt) {
		this.calledAt = calledAt;
	}

	public CallHistoryType getCallType() {
		return callType;
	}

	public void setCallType(CallHistoryType callType) {
		this.callType = callType;
	}

	public boolean isReaded() {
		return readed;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

}

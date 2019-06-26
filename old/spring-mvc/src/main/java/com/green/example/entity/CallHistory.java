package com.green.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import utils.CallHistoryType;

@Entity
@Table(name="call_histories")
public class CallHistory {
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;

	@Column(name="phone")
	private String phone;

	@Column(name="called_at")
	private Date calledAt;

	@Enumerated(EnumType.STRING)
	@Column(name="call_type")
	private CallHistoryType callType;

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
}

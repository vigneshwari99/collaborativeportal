package com.niit.pojo;

import java.util.Date;

public class OutMessage extends Message {

	private Date time;

	public OutMessage(Message original, Date time) {
		super(original.getId(), original.getMessage(), original.getUserId(),original.getUsername());
		this.time = time;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}

package org.quinnox.pojo;

import java.sql.Timestamp;

public class GetDateAndTimeFolderWise {
	private Timestamp timestamp;
	private int count;
	
	public GetDateAndTimeFolderWise() {
		// TODO Auto-generated constructor stub
	}

	public GetDateAndTimeFolderWise(Timestamp timestamp, int count) {
		super();
		this.timestamp = timestamp;
		this.count = count;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "GetDateAndTimeFolderWise [time=" + timestamp + ", count="
				+ count + "]";
	}
	
}

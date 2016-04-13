package org.quinnox.pojo;

import java.sql.Timestamp;

public class GetTimeAndFileCount {
	private Timestamp timestamp;
	private int count;
	
	public GetTimeAndFileCount() {
	}

	public GetTimeAndFileCount(Timestamp timestamp, int count) {
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
		return "GetTimeAndFileCount [timestamp=" + timestamp + ", count="
				+ count + "]";
	}
	
	
}

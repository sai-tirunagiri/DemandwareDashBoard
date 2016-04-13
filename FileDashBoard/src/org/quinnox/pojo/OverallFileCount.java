package org.quinnox.pojo;

import java.sql.Timestamp;

public class OverallFileCount {
	private String timestamp;
	private int count;
	
	public OverallFileCount() {
		// TODO Auto-generated constructor stub
	}

	public OverallFileCount(String timestamp, int count) {
		super();
		this.timestamp = timestamp;
		this.count = count;
	}



	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String string) {
		this.timestamp = string;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "GetOverallFileCount [timestamp=" + timestamp + ", count="
				+ count + "]";
	}
}

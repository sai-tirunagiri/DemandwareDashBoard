package org.quinnox.pojo;

public class GetFileList {
	private String fileList;
	
	public GetFileList() {
		// TODO Auto-generated constructor stub
	}

	public GetFileList(String fileList) {
		super();
		this.fileList = fileList;
	}

	public String getFileList() {
		return fileList;
	}

	public void setFileList(String fileList) {
		this.fileList = fileList;
	}

	@Override
	public String toString() {
		return "GetFileList [fileList=" + fileList + "]";
	}
	
	
}

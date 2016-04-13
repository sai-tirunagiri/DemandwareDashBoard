package org.quinnox.pojo;

public class FileListBasedOnFolderName {
	private String fileList;
	
	public FileListBasedOnFolderName() {
		// TODO Auto-generated constructor stub
	}

	public FileListBasedOnFolderName(String fileList) {
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
		return fileList;
	}
	
	
}

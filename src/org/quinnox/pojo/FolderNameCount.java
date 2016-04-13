package org.quinnox.pojo;

public class FolderNameCount {
	private String folderName;
	private int fileCount;
	
	public FolderNameCount() {
		// TODO Auto-generated constructor stub
	}

	public FolderNameCount(String folderName, int fileCount) {
		super();
		this.folderName = folderName;
		this.fileCount = fileCount;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public int getFileCount() {
		return fileCount;
	}

	public void setFileCount(int i) {
		this.fileCount = i;
	}

	@Override
	public String toString() {
		return "FolderNameCount [folderName=" + folderName + ", fileCount="
				+ fileCount + "]";
	}
	
	
}

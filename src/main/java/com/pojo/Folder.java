package com.pojo;


public class Folder {

	/**
	 * 文件夹编号
	 */
	private Integer folderId = null;

	/**
	 * 文件夹名称
	 */
	private String folderName = null;

	/**
	 * 文件编号
	 */
	private Integer fileId = null;

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	public Integer getFolderId() {
		return this.folderId;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public String getFolderName() {
		return this.folderName;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Integer getFileId() {
		return this.fileId;
	}

}
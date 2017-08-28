package com.pojo;


public class Tatalfile {

	/**
	 * 文件总表编号
	 */
	private Integer totalfileId = null;

	/**
	 * 文件夹编号
	 */
	private Integer folderId = null;

	/**
	 * 文件编号
	 */
	private Integer fileId = null;

	public void setTotalfileId(Integer totalfileId) {
		this.totalfileId = totalfileId;
	}

	public Integer getTotalfileId() {
		return this.totalfileId;
	}

	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}

	public Integer getFolderId() {
		return this.folderId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Integer getFileId() {
		return this.fileId;
	}

}
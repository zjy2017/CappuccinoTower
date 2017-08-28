package com.pojo;


public class File {

	/**
	 * 文件编号
	 */
	private Integer fileId = null;

	/**
	 * 上传路径
	 */
	private String fileUrl = null;

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Integer getFileId() {
		return this.fileId;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFileUrl() {
		return this.fileUrl;
	}

}
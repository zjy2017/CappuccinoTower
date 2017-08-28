package com.pojo;


public class Team {

	/**
	 * 团队编号（主键）
	 */
	private Integer tId = null;

	/**
	 * 团队名称
	 */
	private String tName = null;

	/**
	 * 是否存在分组（0代表无分组，1代表有）默认0
	 */
	private Integer isgroup = null;

	public void setTId(Integer tId) {
		this.tId = tId;
	}

	public Integer getTId() {
		return this.tId;
	}

	public void setTName(String tName) {
		this.tName = tName;
	}

	public String getTName() {
		return this.tName;
	}

	public void setIsgroup(Integer isgroup) {
		this.isgroup = isgroup;
	}

	public Integer getIsgroup() {
		return this.isgroup;
	}

}
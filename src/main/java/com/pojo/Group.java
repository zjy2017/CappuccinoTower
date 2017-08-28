package com.pojo;


public class Group {

	/**
	 * 分组编号（主键）
	 */
	private Integer gId = null;

	/**
	 * 团队编号
	 */
	private Integer tId = null;

	public void setGId(Integer gId) {
		this.gId = gId;
	}

	public Integer getGId() {
		return this.gId;
	}

	public void setTId(Integer tId) {
		this.tId = tId;
	}

	public Integer getTId() {
		return this.tId;
	}

}
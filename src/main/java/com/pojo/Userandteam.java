package com.pojo;


public class Userandteam {

	/**
	 * 编号（自增，主键）
	 */
	private Integer utId = null;

	/**
	 * 团队编号ID
	 */
	private Integer tId = null;

	/**
	 * 用户编号ID
	 */
	private Integer uId = null;

	/**
	 * 用户身份，默认为0（0为组员，1为超管，2为普通管理员，其他为游客）
	 */
	private Integer type = null;

	public void setUtId(Integer utId) {
		this.utId = utId;
	}

	public Integer getUtId() {
		return this.utId;
	}

	public void setTId(Integer tId) {
		this.tId = tId;
	}

	public Integer getTId() {
		return this.tId;
	}

	public void setUId(Integer uId) {
		this.uId = uId;
	}

	public Integer getUId() {
		return this.uId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return this.type;
	}

}
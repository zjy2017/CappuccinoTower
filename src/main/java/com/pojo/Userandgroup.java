package com.pojo;


public class Userandgroup {

	/**
	 * 编号（主键）
	 */
	private Integer ugId = null;

	/**
	 * 用户编号
	 */
	private Integer uId = null;

	/**
	 * 分组编号
	 */
	private Integer gId = null;

	public void setUgId(Integer ugId) {
		this.ugId = ugId;
	}

	public Integer getUgId() {
		return this.ugId;
	}

	public void setUId(Integer uId) {
		this.uId = uId;
	}

	public Integer getUId() {
		return this.uId;
	}

	public void setGId(Integer gId) {
		this.gId = gId;
	}

	public Integer getGId() {
		return this.gId;
	}

}
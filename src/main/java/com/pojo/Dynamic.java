package com.pojo;

import java.sql.Timestamp;

public class Dynamic {

	/**
	 * 动态编号
	 */
	private Integer dynamicId = null;

	/**
	 * 动态创建时间
	 */
	private Timestamp dTime = null;

	/**
	 * 项目编号
	 */
	private Integer pId = null;

	/**
	 * 操作
	 */
	private String action = null;

	/**
	 * 用户编号
	 */
	private Integer uId = null;

	/**
	 * 被操作对象
	 */
	private Integer beOperated = null;

	/**
	 * 被操作表
	 */
	private String beTable = null;

	public void setDynamicId(Integer dynamicId) {
		this.dynamicId = dynamicId;
	}

	public Integer getDynamicId() {
		return this.dynamicId;
	}

	public void setDTime(Timestamp dTime) {
		this.dTime = dTime;
	}

	public Timestamp getDTime() {
		return this.dTime;
	}

	public void setPId(Integer pId) {
		this.pId = pId;
	}

	public Integer getPId() {
		return this.pId;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getAction() {
		return this.action;
	}

	public void setUId(Integer uId) {
		this.uId = uId;
	}

	public Integer getUId() {
		return this.uId;
	}

	public void setBeOperated(Integer beOperated) {
		this.beOperated = beOperated;
	}

	public Integer getBeOperated() {
		return this.beOperated;
	}

	public void setBeTable(String beTable) {
		this.beTable = beTable;
	}

	public String getBeTable() {
		return this.beTable;
	}

}
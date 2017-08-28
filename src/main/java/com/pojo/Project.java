package com.pojo;


public class Project {

	/**
	 * 项目编号（主键）
	 */
	private Integer pId = null;

	/**
	 * 项目名称
	 */
	private String pName = null;

	/**
	 * 项目描述（可为空）
	 */
	private String pDescribe = null;

	/**
	 * 是否敏感信息（0为不敏感，1为敏感）默认0
	 */
	private Integer pSensitive = null;

	/**
	 * 是否公开（0为公开，1为公开）默认不公开
	 */
	private Integer ispublic = null;

	/**
	 * 团队编号
	 */
	private Integer tId = null;

	/**
	 * 讨论总表编号
	 */
	private Integer discusallid = null;

	/**
	 * 文件总表编号
	 */
	private Integer fTotalid = null;

	public void setPId(Integer pId) {
		this.pId = pId;
	}

	public Integer getPId() {
		return this.pId;
	}

	public void setPName(String pName) {
		this.pName = pName;
	}

	public String getPName() {
		return this.pName;
	}

	public void setPDescribe(String pDescribe) {
		this.pDescribe = pDescribe;
	}

	public String getPDescribe() {
		return this.pDescribe;
	}

	public void setPSensitive(Integer pSensitive) {
		this.pSensitive = pSensitive;
	}

	public Integer getPSensitive() {
		return this.pSensitive;
	}

	public void setIspublic(Integer ispublic) {
		this.ispublic = ispublic;
	}

	public Integer getIspublic() {
		return this.ispublic;
	}

	public void setTId(Integer tId) {
		this.tId = tId;
	}

	public Integer getTId() {
		return this.tId;
	}

	public void setDiscusallid(Integer discusallid) {
		this.discusallid = discusallid;
	}

	public Integer getDiscusallid() {
		return this.discusallid;
	}

	public void setFTotalid(Integer fTotalid) {
		this.fTotalid = fTotalid;
	}

	public Integer getFTotalid() {
		return this.fTotalid;
	}

}
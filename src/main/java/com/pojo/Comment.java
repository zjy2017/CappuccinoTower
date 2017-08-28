package com.pojo;

import java.sql.Timestamp;

public class Comment {

	/**
	 * 评论编号
	 */
	private Integer cId = null;

	/**
	 * 评论内容
	 */
	private String cContent = null;

	/**
	 * 发起评论者
	 */
	private Integer uId = null;

	/**
	 * 任务编号
	 */
	private Integer taskId = null;

	/**
	 * 评论时间
	 */
	private Timestamp cTime = null;

	public void setCId(Integer cId) {
		this.cId = cId;
	}

	public Integer getCId() {
		return this.cId;
	}

	public void setCContent(String cContent) {
		this.cContent = cContent;
	}

	public String getCContent() {
		return this.cContent;
	}

	public void setUId(Integer uId) {
		this.uId = uId;
	}

	public Integer getUId() {
		return this.uId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getTaskId() {
		return this.taskId;
	}

	public void setCTime(Timestamp cTime) {
		this.cTime = cTime;
	}

	public Timestamp getCTime() {
		return this.cTime;
	}

}
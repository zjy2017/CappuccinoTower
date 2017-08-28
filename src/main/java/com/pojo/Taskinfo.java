package com.pojo;


public class Taskinfo {

	/**
	 * 任务清单编号
	 */
	private Integer taskinfoId = null;

	/**
	 * 任务清单名称
	 */
	private String taskinfoName = null;

	/**
	 * 任务清单描述
	 */
	private String takinfoDescribe = null;

	/**
	 * 任务编号
	 */
	private Integer taskId = null;

	/**
	 * 任务清单创建者
	 */
	private Integer taskinfoUser = null;

	/**
	 * 项目编号
	 */
	private Integer pId = null;

	public void setTaskinfoId(Integer taskinfoId) {
		this.taskinfoId = taskinfoId;
	}

	public Integer getTaskinfoId() {
		return this.taskinfoId;
	}

	public void setTaskinfoName(String taskinfoName) {
		this.taskinfoName = taskinfoName;
	}

	public String getTaskinfoName() {
		return this.taskinfoName;
	}

	public void setTakinfoDescribe(String takinfoDescribe) {
		this.takinfoDescribe = takinfoDescribe;
	}

	public String getTakinfoDescribe() {
		return this.takinfoDescribe;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskinfoUser(Integer taskinfoUser) {
		this.taskinfoUser = taskinfoUser;
	}

	public Integer getTaskinfoUser() {
		return this.taskinfoUser;
	}

	public void setPId(Integer pId) {
		this.pId = pId;
	}

	public Integer getPId() {
		return this.pId;
	}

}
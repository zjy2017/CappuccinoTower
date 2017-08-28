package com.pojo;

import java.sql.Timestamp;

public class Task {

	/**
	 * 任务编号（主键）
	 */
	private Integer taskId = null;

	/**
	 * 任务名称
	 */
	private String taskName = null;

	/**
	 * 任务描述（可为空）
	 */
	private String taskDescribe = null;

	/**
	 * 任务创建时间
	 */
	private Timestamp taskCreatetime = null;

	/**
	 * 任务完成时间
	 */
	private Timestamp taskFinishtime = null;

	/**
	 * 任务创建人
	 */
	private Integer taskUser = null;

	/**
	 * 任务被指派者
	 */
	private Integer taskAssigner = null;

	/**
	 * 状态（0未开始，1正在执行，2完成）默认0
	 */
	private Integer status = null;

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskDescribe(String taskDescribe) {
		this.taskDescribe = taskDescribe;
	}

	public String getTaskDescribe() {
		return this.taskDescribe;
	}

	public void setTaskCreatetime(Timestamp taskCreatetime) {
		this.taskCreatetime = taskCreatetime;
	}

	public Timestamp getTaskCreatetime() {
		return this.taskCreatetime;
	}

	public void setTaskFinishtime(Timestamp taskFinishtime) {
		this.taskFinishtime = taskFinishtime;
	}

	public Timestamp getTaskFinishtime() {
		return this.taskFinishtime;
	}

	public void setTaskUser(Integer taskUser) {
		this.taskUser = taskUser;
	}

	public Integer getTaskUser() {
		return this.taskUser;
	}

	public void setTaskAssigner(Integer taskAssigner) {
		this.taskAssigner = taskAssigner;
	}

	public Integer getTaskAssigner() {
		return this.taskAssigner;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return this.status;
	}

}
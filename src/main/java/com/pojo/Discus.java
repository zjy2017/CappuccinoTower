package com.pojo;


public class Discus {

	/**
	 * 讨论编号（主键）
	 */
	private Integer discusId = null;

	/**
	 * 讨论话题
	 */
	private String dTopic = null;

	/**
	 * 讨论内容
	 */
	private String dContent = null;

	public void setDiscusId(Integer discusId) {
		this.discusId = discusId;
	}

	public Integer getDiscusId() {
		return this.discusId;
	}

	public void setDTopic(String dTopic) {
		this.dTopic = dTopic;
	}

	public String getDTopic() {
		return this.dTopic;
	}

	public void setDContent(String dContent) {
		this.dContent = dContent;
	}

	public String getDContent() {
		return this.dContent;
	}

}
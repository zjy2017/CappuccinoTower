package com.pojo;


public class User {

	/**
	 * 用户编号（主键）
	 */
	private Integer uId;

	/**
	 * 用户邮箱
	 */
	private String uEmail;

	/**
	 * 用户密码
	 */
	private String uPassword;

	/**
	 * 用户头像（可为空）
	 */
	private String uPicture;

	/**
	 * 用户名
	 */
	private String uName;

	public void setUId(Integer uId) {
		this.uId = uId;
	}

	public Integer getUId() {
		return this.uId;
	}

	public void setUEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getUEmail() {
		return this.uEmail;
	}

	public void setUPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getUPassword() {
		return this.uPassword;
	}

	public void setUPicture(String uPicture) {
		this.uPicture = uPicture;
	}

	public String getUPicture() {
		return this.uPicture;
	}

	public void setUName(String uName) {
		this.uName = uName;
	}

	public String getUName() {
		return this.uName;
	}

	@Override
	public String toString() {
		return "User{" +
				"uId=" + uId +
				", uEmail='" + uEmail + '\'' +
				", uPassword='" + uPassword + '\'' +
				", uPicture='" + uPicture + '\'' +
				", uName='" + uName + '\'' +
				'}';
	}
}
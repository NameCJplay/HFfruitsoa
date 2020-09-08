package com.hf.domain.Domain.User;

import java.io.Serializable;


public class UserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户id
	private Long userId;
	//用户名
	private String userName;
	//密码
	private String userPwd;
	//手机号
	private String userMobile;
	//邮箱
	private String userEmail;
	//头像
	private String userImg;
	//性别
	private String userSex;
	//生日
	private String userBirth;
	//创建时间
	private String userCreate;
	//修改时间
	private String userModified;
	//状态 0:禁用，1:正常
	private Integer userStatus;
	//权限 1:普通用户，2:管理员
	private Integer userRole;
	//部门id
	private Long userDeptId;
	//部门名称
	private String userDeptName;

	public String getUserDeptName() {
		return userDeptName;
	}

	public void setUserDeptName(String userDeptName) {
		this.userDeptName = userDeptName;
	}

	/**
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：密码
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	/**
	 * 获取：密码
	 */
	public String getUserPwd() {
		return userPwd;
	}
	/**
	 * 设置：手机号
	 */
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getUserMobile() {
		return userMobile;
	}
	/**
	 * 设置：邮箱
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * 获取：邮箱
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * 设置：头像
	 */
	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}
	/**
	 * 获取：头像
	 */
	public String getUserImg() {
		return userImg;
	}
	/**
	 * 设置：性别
	 */
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	/**
	 * 获取：性别
	 */
	public String getUserSex() {
		return userSex;
	}
	/**
	 * 设置：生日
	 */
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	/**
	 * 获取：生日
	 */
	public String getUserBirth() {
		return userBirth;
	}
	/**
	 * 设置：创建时间
	 */
	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}
	/**
	 * 获取：创建时间
	 */
	public String getUserCreate() {
		return userCreate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUserModified(String userModified) {
		this.userModified = userModified;
	}
	/**
	 * 获取：修改时间
	 */
	public String getUserModified() {
		return userModified;
	}
	/**
	 * 设置：状态 0:禁用，1:正常
	 */
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	/**
	 * 获取：状态 0:禁用，1:正常
	 */
	public Integer getUserStatus() {
		return userStatus;
	}
	/**
	 * 设置：权限 1:普通用户，2:管理员
	 */
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	/**
	 * 获取：权限 1:普通用户，2:管理员
	 */
	public Integer getUserRole() {
		return userRole;
	}
	/**
	 * 设置：部门id
	 */
	public void setUserDeptId(Long userDeptId) {
		this.userDeptId = userDeptId;
	}
	/**
	 * 获取：部门id
	 */
	public Long getUserDeptId() {
		return userDeptId;
	}


	@Override
	public String toString() {
		return "UserDO{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", userPwd='" + userPwd + '\'' +
				", userMobile='" + userMobile + '\'' +
				", userEmail='" + userEmail + '\'' +
				", userImg='" + userImg + '\'' +
				", userSex='" + userSex + '\'' +
				", userBirth='" + userBirth + '\'' +
				", userCreate='" + userCreate + '\'' +
				", userModified='" + userModified + '\'' +
				", userStatus=" + userStatus +
				", userRole=" + userRole +
				", userDeptId=" + userDeptId +
				", userDeptName='" + userDeptName + '\'' +
				'}';
	}
}

/*
*toString
*return ReflectionToStringBuilder.toString(this);     
*
*
*/

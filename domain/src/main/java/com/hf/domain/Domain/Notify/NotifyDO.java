package com.hf.domain.Domain.Notify;

import java.io.Serializable;
import java.util.Date;


public class NotifyDO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long notifyId;
	//发布者id
	private Long notifyUserId;
	//发布者name
	private String notifyUserName;
	//接受者id
	private Long notifyThatuser;
	//标题
	private String notifyTitle;
	//类型
	private String notifyType;
	//内容
	private String notifyContent;
	//备注信息
	private String notifyRemarks;
	//创建时间
	private Date notifyCreateDate;
	//更新时间
	private Date notifyUpdateDate;

	/**
	 * 设置：编号
	 */
	public void setNotifyId(Long notifyId) {
		this.notifyId = notifyId;
	}
	/**
	 * 获取：编号
	 */
	public Long getNotifyId() {
		return notifyId;
	}
	/**
	 * 设置：发布者id
	 */
	public void setNotifyUserId(Long notifyUserId) {
		this.notifyUserId = notifyUserId;
	}
	/**
	 * 获取：发布者id
	 */
	public Long getNotifyUserId() {
		return notifyUserId;
	}

	public String getNotifyUserName() {
		return notifyUserName;
	}

	public void setNotifyUserName(String notifyUserName) {
		this.notifyUserName = notifyUserName;
	}

	/**
	 * 设置：接受者id
	 */
	public void setNotifyThatuser(Long notifyThatuser) {
		this.notifyThatuser = notifyThatuser;
	}
	/**
	 * 获取：接受者id
	 */
	public Long getNotifyThatuser() {
		return notifyThatuser;
	}
	/**
	 * 设置：标题
	 */
	public void setNotifyTitle(String notifyTitle) {
		this.notifyTitle = notifyTitle;
	}
	/**
	 * 获取：标题
	 */
	public String getNotifyTitle() {
		return notifyTitle;
	}
	/**
	 * 设置：类型
	 */
	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}
	/**
	 * 获取：类型
	 */
	public String getNotifyType() {
		return notifyType;
	}
	/**
	 * 设置：内容
	 */
	public void setNotifyContent(String notifyContent) {
		this.notifyContent = notifyContent;
	}
	/**
	 * 获取：内容
	 */
	public String getNotifyContent() {
		return notifyContent;
	}
	/**
	 * 设置：备注信息
	 */
	public void setNotifyRemarks(String notifyRemarks) {
		this.notifyRemarks = notifyRemarks;
	}
	/**
	 * 获取：备注信息
	 */
	public String getNotifyRemarks() {
		return notifyRemarks;
	}
	/**
	 * 设置：创建时间
	 */
	public void setNotifyCreateDate(Date notifyCreateDate) {
		this.notifyCreateDate = notifyCreateDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getNotifyCreateDate() {
		return notifyCreateDate;
	}
	/**
	 * 设置：更新时间
	 */
	public void setNotifyUpdateDate(Date notifyUpdateDate) {
		this.notifyUpdateDate = notifyUpdateDate;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getNotifyUpdateDate() {
		return notifyUpdateDate;
	}
}

/*
*toString
*return ReflectionToStringBuilder.toString(this);     
*
*
*/

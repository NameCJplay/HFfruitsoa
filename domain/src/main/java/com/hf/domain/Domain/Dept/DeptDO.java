package com.hf.domain.Domain.Dept;

import java.io.Serializable;


public class DeptDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long deptId;
	//上级部门
	private Long deptParentid;
	//部门名称
	private String deptName;
	//所在地址
	private String deptAddress;

	/**
	 * 设置：
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * 设置：上级部门
	 */
	public void setDeptParentid(Long deptParentid) {
		this.deptParentid = deptParentid;
	}
	/**
	 * 获取：上级部门
	 */
	public Long getDeptParentid() {
		return deptParentid;
	}
	/**
	 * 设置：部门名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 获取：部门名称
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 设置：所在地址
	 */
	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}
	/**
	 * 获取：所在地址
	 */
	public String getDeptAddress() {
		return deptAddress;
	}
}

/*
*toString
*return ReflectionToStringBuilder.toString(this);     
*
*
*/

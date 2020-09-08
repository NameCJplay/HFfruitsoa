package com.hf.domain.Domain.Classify;

import java.io.Serializable;


public class ClassifyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long classifyId;
	//上级id
	private Long classifyParentid;
	//分类名称
	private String classifyName;

	/**
	 * 设置：编号
	 */
	public void setClassifyId(Long classifyId) {
		this.classifyId = classifyId;
	}
	/**
	 * 获取：编号
	 */
	public Long getClassifyId() {
		return classifyId;
	}
	/**
	 * 设置：上级id
	 */
	public void setClassifyParentid(Long classifyParentid) {
		this.classifyParentid = classifyParentid;
	}
	/**
	 * 获取：上级id
	 */
	public Long getClassifyParentid() {
		return classifyParentid;
	}
	/**
	 * 设置：分类名称
	 */
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	/**
	 * 获取：分类名称
	 */
	public String getClassifyName() {
		return classifyName;
	}
}

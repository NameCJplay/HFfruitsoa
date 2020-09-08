package com.hf.domain.Domain.Notify;

import java.io.Serializable;


public class NotifyFileDO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//编号
	private Long fileId;
	//消息编号
	private Long fileNotifyId;
	//存储路径
	private String filePath;
	//存储文件名
	private String fileFilename;
	//文件名
	private String fileName;

	/**
	 * 设置：编号
	 */
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	/**
	 * 获取：编号
	 */
	public Long getFileId() {
		return fileId;
	}
	/**
	 * 设置：消息编号
	 */
	public void setFileNotifyId(Long fileNotifyId) {
		this.fileNotifyId = fileNotifyId;
	}
	/**
	 * 获取：消息编号
	 */
	public Long getFileNotifyId() {
		return fileNotifyId;
	}
	/**
	 * 设置：存储路径
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * 获取：存储路径
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * 设置：存储文件名
	 */
	public void setFileFilename(String fileFilename) {
		this.fileFilename = fileFilename;
	}
	/**
	 * 获取：存储文件名
	 */
	public String getFileFilename() {
		return fileFilename;
	}
	/**
	 * 设置：文件名
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * 获取：文件名
	 */
	public String getFileName() {
		return fileName;
	}


	public NotifyFileDO(Long fileId, Long fileNotifyId, String filePath, String fileFilename, String fileName) {
		this.fileId = fileId;
		this.fileNotifyId = fileNotifyId;
		this.filePath = filePath;
		this.fileFilename = fileFilename;
		this.fileName = fileName;
	}
}

/*
*toString
*return ReflectionToStringBuilder.toString(this);     
*
*
*/

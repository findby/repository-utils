package com.develop.part.designpattern.simple.entity;

/***
 *@author feiwenxiang
 *@Description: 简易网盘Entity
 *@date 2020年3月24日
 */
public class SimpleDrive{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4430322331619795830L;
	
	private Integer fileId;
	private Integer parentId;
	private String name;
	private Integer parentIds;
	private String parentIdName;
	private Integer type;
	private Integer status;
	private Integer userId;
	
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParentIds() {
		return parentIds;
	}
	public void setParentIds(Integer parentIds) {
		this.parentIds = parentIds;
	}
	public String getParentIdName() {
		return parentIdName;
	}
	public void setParentIdName(String parentIdName) {
		this.parentIdName = parentIdName;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}

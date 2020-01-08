package com.develop.part.mybatis.generator.pojo;

import java.io.Serializable;

public class SysOffice implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -4921163968041768734L;

	/** **/
    private Integer id;

    /** **/
    private Integer parentid;

    /** **/
    private String name;

    /** **/
    private Integer sort;

    /** **/
    private Integer isenable;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getIsenable() {
		return isenable;
	}

	public void setIsenable(Integer isenable) {
		this.isenable = isenable;
	}
}
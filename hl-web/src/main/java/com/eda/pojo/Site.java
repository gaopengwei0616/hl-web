package com.eda.pojo;

public class Site {
	private Integer siteid;
	private String name;
	private Integer type;	//2、政府组成部门 3、街道 4、直属事业单位 5、其他部门
	private String url;
	private Integer status;
	private Integer catid;

	public Integer getCatid() {
		return catid;
	}

	public void setCatid(Integer catid) {
		this.catid = catid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSiteid() {
		return siteid;
	}
	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}

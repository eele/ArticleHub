package edu.zhku.jsj144.lzc.articleHub.pojo;

import java.lang.reflect.Field;

public class Video extends Page {
	private String fieldName = null;
	private String vid = null;
	private String uid = null;
	private String title = null;
	private String category = null;
	private String description = null;
	private String pid = null;
	private Boolean permission = false;
	private String password = null;
	private String path = null;
	private int verify = 0;
	private String datetime = null;

	public String getSelectedFieldName() {
		return fieldName;
	}

	public void set(String fieldName, String value) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = this.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(this, value);
		this.fieldName = fieldName;
	}

	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Boolean getPermission() {
		return permission;
	}

	public void setPermission(Boolean permission) {
		this.permission = permission;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}

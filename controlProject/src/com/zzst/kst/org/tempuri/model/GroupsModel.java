package com.zzst.kst.org.tempuri.model;

public class GroupsModel {
private String id;
private String name;
private String type;
private String pid;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public String getPid() {
	return pid;
}
public void setPid(String pid) {
	this.pid = pid;
}
public GroupsModel(String id, String name, String type,String pid) {
	super();
	this.id = id;
	this.name = name;
	this.type = type;
	this.pid= pid;
}


}

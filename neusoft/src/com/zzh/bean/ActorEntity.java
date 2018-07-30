package com.zzh.bean;

public class ActorEntity {
private int id = 0;
private String name = "null";
private String sex = "null";
private String birth = "null";
private String hometown = "null";
private String occupation = "null";
private String describe = "null";
private String url = "null";

@Override
public String toString() {
	return "{\"id\":\"" + id + "\",\"name\":\"" + name + "\",\"sex\":\"" + sex + "\",\"birth\":\"" + birth
			+ "\",\"hometown\":\"" + hometown + "\",\"occupation\":\"" + occupation + "\",\"describe\":\"" + describe
			+ "\",\"url\":\"" + url + "\"}  ";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getBirth() {
	return birth;
}
public void setBirth(String birth) {
	this.birth = birth;
}
public String getHometown() {
	return hometown;
}
public void setHometown(String hometown) {
	this.hometown = hometown;
}
public String getOccupation() {
	return occupation;
}
public void setOccupation(String occupation) {
	this.occupation = occupation;
}
public String getDescribe() {
	return describe;
}
public void setDescribe(String describe) {
	this.describe = describe;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}

public ActorEntity() {
	super();
}
public ActorEntity(int id, String name, String sex, String birth, String hometown, String occupation, String describe,
		String url) {
	super();
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.birth = birth;
	this.hometown = hometown;
	this.occupation = occupation;
	this.describe = describe;
	this.url = url;
}

}

package com.zzh.bean;

public class CommentEntity {
private  int id;
private  float score;
private String comments;
private int user_id;
private int movie_id;
private String date;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public float getScore() {
	return score;
}
public void setScore(float score) {
	this.score = score;
}
public String getComments() {
	return comments;
}
public void setComments(String comments) {
	this.comments = comments;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public int getMovie_id() {
	return movie_id;
}
public void setMovie_id(int movie_id) {
	this.movie_id = movie_id;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}

}

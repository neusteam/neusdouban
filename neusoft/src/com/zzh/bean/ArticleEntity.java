package com.zzh.bean;

import java.util.Date;

import com.zzh.util.Time;

public class ArticleEntity {
	
	private String articleId;
	private String authorId;
	private String content;
	private String movieId;
	private String date;
	
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getDate() {
		Time time = new Time();
		return time.getCurrentTime();
	}
	public void setDate(String date) {
		this.date = date;
	}

	

}

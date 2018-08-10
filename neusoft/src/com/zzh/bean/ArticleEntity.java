package com.zzh.bean;

import java.util.ArrayList;
import java.util.Date;

import com.zzh.util.Time;

public class ArticleEntity {
	
	private String articleId;
	private String movieName;
	private String authorId;
	private String content;
	private String movieId;
	private String date;
	private int sts;
	private String title;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getSts() {
		return sts;
	}
	public void setSts(int sts) {
		this.sts = sts;
	}
	@Override
	public String toString() {
		return "{\"articleId\":\"" + articleId + "\",\"authorId\":\"" + authorId + "\",\"content\":\"" + content
				+ "\",\"movieId\":\"" + movieId + "\",\"date\":\"" + date + "\"}";
	}
	public String getArticleId() {
		return articleId;
	}
	
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
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
	
	public String parseJson(ArrayList<ArticleEntity> aeList){
		String rs = "[";
		
		for(ArticleEntity ae:aeList){
			rs = rs +ae.toString() + ",";
		}
		rs = rs.substring(0,rs.length() - 1);
		rs = rs + "]";
		return rs;
	}

	
//	public static void main(String[] args) {
//		ArticleEntity ae = new ArticleEntity();
//		ae.setMovieId("1");
//		ae.setArticleId("2");
//		ae.setAuthorId("3");
//		ae.setContent("asd");
//		ae.setDate("2018");
//		
//		ArticleEntity ae2 = new ArticleEntity();
//		ae2.setMovieId("2");
//		ae2.setArticleId("2");
//		ae2.setAuthorId("3");
//		ae2.setContent("asd");
//		ae2.setDate("2018");
//		
//		ArrayList<ArticleEntity> al = new ArrayList<ArticleEntity>();
//		al.add(ae);
//		al.add(ae2);
//		
//		String rs = ae.parseJson(al);
//		System.out.println(rs);
//		
//	}
	

}

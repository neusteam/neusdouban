package com.zzh.bean;

public class MovieEntity {
<<<<<<< HEAD
	
	
	private int movieId;
	private String movieName;
	private String date;
	private String director;
	private String actor;
	private String type;
	private String country;
	private String language;
	private String picture;
	private double average;
	private String describe;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
public static void main(String[] args) {
	MovieEntity m = new MovieEntity();
System.out.println(m.toString());	
			
}

=======
 private int movie_id;
 private String movieName;
 private String date;
 private String director;
 private String actor;
 private String type;
 private String country;
 private String language;
 private String picture;
 private float average;
 private String describe;
public int getMovie_id() {
	return movie_id;
>>>>>>> 8557e127c8ba82d347e624b262b75af5fcdb113c
}
public void setMovie_id(int movie_id) {
	this.movie_id = movie_id;
}
public String getMovieName() {
	return movieName;
}
public void setMovieName(String movieName) {
	this.movieName = movieName;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public String getActor() {
	return actor;
}
public void setActor(String actor) {
	this.actor = actor;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
public float getAverage() {
	return average;
}
public void setAverage(float average) {
	this.average = average;
}
public String getDescribe() {
	return describe;
}
public void setDescribe(String describe) {
	this.describe = describe;
}
public MovieEntity(int movie_id, String movieName, String date, String director, String actor, String type,
		String country, String language, String picture, float average, String describe) {
	super();
	this.movie_id = movie_id;
	this.movieName = movieName;
	this.date = date;
	this.director = director;
	this.actor = actor;
	this.type = type;
	this.country = country;
	this.language = language;
	this.picture = picture;
	this.average = average;
	this.describe = describe;
}
public MovieEntity() {
	super();
}
@Override
public String toString() {
	return "{'movie_id':'" + movie_id + "','movieName':'" + movieName + "','date':'" + date + "','director':'"
			+ director + "','actor':'" + actor + "','type':'" + type + "','country':'" + country + "','language':'"
			+ language + "','picture':'" + picture + "','average':'" + average + "','describe':'" + describe + "'}";
}
}
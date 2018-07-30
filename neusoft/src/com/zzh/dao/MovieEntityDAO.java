package com.zzh.dao;



import java.util.ArrayList;

import com.zzh.bean.MovieEntity;


public interface MovieEntityDAO {
	public boolean addMovie(MovieEntity me);
	public boolean altMovie(MovieEntity me);
	public ArrayList<MovieEntity> getMovieList(int count);
	
}

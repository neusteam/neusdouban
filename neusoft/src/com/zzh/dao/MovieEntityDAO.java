package com.zzh.dao;

import com.zzh.bean.MovieEntity;

public interface MovieEntityDAO {
	
	public boolean addMovie(MovieEntity me);
	
	public boolean altMovie(MovieEntity me);
}

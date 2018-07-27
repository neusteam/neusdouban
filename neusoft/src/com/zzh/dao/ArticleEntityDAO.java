package com.zzh.dao;
import java.util.ArrayList;

import com.zzh.bean.ArticleEntity;
import com.zzh.bean.MovieEntity;

public interface ArticleEntityDAO {
	
	public boolean addArticle(ArticleEntity ae);
	
	public boolean altArticle(ArticleEntity ae);
	
	public boolean delArticle(ArticleEntity ae);

	public MovieEntity fndMovieByArticleId(ArticleEntity ae);
}

package com.dems_care.demscare.manager.http;

import com.dems_care.demscare.dao.ArticleItemCollectionDao;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Bon on 18/9/2560.
 */

public interface ApiService {

    @GET("articles")
    Call<ArticleItemCollectionDao> loadArticleList();
}

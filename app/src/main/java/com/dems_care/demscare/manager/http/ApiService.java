package com.dems_care.demscare.manager.http;

import com.dems_care.demscare.dao.article.ArticleItemCollectionDao;
import com.dems_care.demscare.dao.book.BookItemCollectionDao;
import com.dems_care.demscare.dao.quiz.QuizItemCollectionDao;
import com.dems_care.demscare.dao.video.VideoItemCollectionDao;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Bon on 18/9/2560.
 */

public interface ApiService {

    @GET("articles")
    Call<ArticleItemCollectionDao> loadArticleList();

    @GET("videos")
    Call<VideoItemCollectionDao> loadVideoList();

    @GET("books")
    Call<BookItemCollectionDao> loadBookList();

    @GET("quizs")
    Call<QuizItemCollectionDao> loadQuizList();
}

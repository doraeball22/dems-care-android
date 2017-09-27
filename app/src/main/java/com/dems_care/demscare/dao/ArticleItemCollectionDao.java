package com.dems_care.demscare.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Bon on 18/9/2560.
 */

public class ArticleItemCollectionDao {

    @SerializedName("success") private boolean success;
    @SerializedName("articles") private List<ArticleItemDao> articles;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<ArticleItemDao> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleItemDao> articles) {
        this.articles = articles;
    }
}

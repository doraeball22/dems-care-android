package com.dems_care.demscare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dems_care.demscare.dao.article.ArticleItemCollectionDao;
import com.dems_care.demscare.dao.article.ArticleItemDao;
import com.dems_care.demscare.view.ArticleListItem;

/**
 * Created by Bon on 14/9/2560.
 */
public class ArticleListAdapter extends BaseAdapter {

    ArticleItemCollectionDao dao;

    public ArticleItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(ArticleItemCollectionDao dao) {
        this.dao = dao;
    }

    @Override
    public int getCount() {
        if(dao == null)
            return 0;
        if(dao.getArticles() == null)
            return 0;
        return dao.getArticles().size();
    }

    @Override
    public Object getItem(int position) {

        return dao.getArticles().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ArticleListItem item;
        if (convertView != null)
            item = (ArticleListItem) convertView;
        else
            item = new ArticleListItem(parent.getContext());

        // get Data from DAO
        ArticleItemDao dao = (ArticleItemDao) getItem(position);
        // set value
        item.setNameTitle(dao.getTitle());
        item.setImageUrl(dao.getImageUrl());

        return item;
    }
}

package com.dems_care.demscare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dems_care.demscare.dao.ArticleItemCollectionDao;
import com.dems_care.demscare.dao.ArticleItemDao;
import com.dems_care.demscare.view.ArticleListItem;
import com.dems_care.demscare.view.VideoListItem;

/**
 * Created by Bon on 14/9/2560.
 */
public class VideoListAdapter extends BaseAdapter {

    ArticleItemCollectionDao dao;

    public void setDao(ArticleItemCollectionDao dao) {
        this.dao = dao;
    }

    public ArticleItemCollectionDao getDao() {
        return dao;
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
        VideoListItem item;
        if (convertView != null)
            item = ( VideoListItem) convertView;
        else
            item = new  VideoListItem(parent.getContext());

        // get Data from DAO
        ArticleItemDao dao = (ArticleItemDao) getItem(position);
        // set value
        item.setNameTitle(dao.getTitle());
        item.setImageUrl(dao.getImageUrl());

        return item;
    }
}

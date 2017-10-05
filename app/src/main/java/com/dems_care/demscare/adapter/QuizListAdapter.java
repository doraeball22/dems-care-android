package com.dems_care.demscare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dems_care.demscare.dao.quiz.Quiz;
import com.dems_care.demscare.dao.quiz.QuizItemCollectionDao;
import com.dems_care.demscare.view.QuizListItem;

/**
 * Created by Bon on 14/9/2560.
 */
public class QuizListAdapter extends BaseAdapter {

    QuizItemCollectionDao dao;

    public QuizItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(QuizItemCollectionDao dao) {
        this.dao = dao;
    }

    @Override
    public int getCount() {
        if (dao == null)
            return 0;
        if (dao.getQuizs() == null)
            return 0;
        return dao.getQuizs().size();
    }

    @Override
    public Object getItem(int position) {

        return dao.getQuizs().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        QuizListItem item;
        if (convertView != null)
            item = (QuizListItem) convertView;
        else
            item = new QuizListItem(parent.getContext());

        // get Data from DAO
        Quiz dao = (Quiz) getItem(position);
        // set value
        item.setNameTitle(dao.getTitle());
        item.setImageUrl(dao.getImageUrl());

        return item;
    }
}

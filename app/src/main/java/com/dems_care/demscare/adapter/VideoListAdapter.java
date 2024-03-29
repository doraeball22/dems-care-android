package com.dems_care.demscare.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.dems_care.demscare.dao.video.VideoItemCollectionDao;
import com.dems_care.demscare.dao.video.VideoItemDao;
import com.dems_care.demscare.view.VideoListItem;

/**
 * Created by Bon on 14/9/2560.
 */
public class VideoListAdapter extends BaseAdapter {

    VideoItemCollectionDao dao;

    public VideoItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(VideoItemCollectionDao dao) {
        this.dao = dao;
    }

    @Override
    public int getCount() {
        if(dao == null)
            return 0;
        if (dao.getVideos() == null)
            return 0;
        return dao.getVideos().size();
    }

    @Override
    public Object getItem(int position) {

        return dao.getVideos().get(position);
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
        VideoItemDao dao = (VideoItemDao) getItem(position);
        // set value
        item.setNameTitle(dao.getTitle());
        item.setImageUrl(dao.getImageUrl());

        return item;
    }
}

package com.dems_care.demscare.manager;

import android.content.Context;

import com.dems_care.demscare.dao.video.VideoItemCollectionDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by Bon on 14/9/2560.
 */
public class VideoListManager {

    private static VideoListManager instance;
    private Context mContext;
    private VideoItemCollectionDao dao;

    private VideoListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public static VideoListManager getInstance() {
        if (instance == null)
            instance = new VideoListManager();
        return instance;
    }

    public static void setInstance(VideoListManager instance) {
        VideoListManager.instance = instance;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public VideoItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(VideoItemCollectionDao dao) {
        this.dao = dao;
    }

}

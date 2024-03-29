package com.dems_care.demscare.manager;

import android.content.Context;

import com.dems_care.demscare.dao.article.ArticleItemCollectionDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by Bon on 14/9/2560.
 */
public class ArticleListManager {

    private static ArticleListManager instance;
    private Context mContext;
    private ArticleItemCollectionDao dao;

    private ArticleListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public static ArticleListManager getInstance() {
        if (instance == null)
            instance = new ArticleListManager();
        return instance;
    }

    public static void setInstance(ArticleListManager instance) {
        ArticleListManager.instance = instance;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public ArticleItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(ArticleItemCollectionDao dao) {
        this.dao = dao;
    }

}

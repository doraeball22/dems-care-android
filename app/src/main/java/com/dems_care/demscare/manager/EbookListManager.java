package com.dems_care.demscare.manager;

import android.content.Context;

import com.dems_care.demscare.dao.ebook.EbookItemCollectionDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by Bon on 14/9/2560.
 */
public class EbookListManager {

    private static EbookListManager instance;
    private Context mContext;
    private EbookItemCollectionDao dao;

    private EbookListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public static EbookListManager getInstance() {
        if (instance == null)
            instance = new EbookListManager();
        return instance;
    }

    public static void setInstance(EbookListManager instance) {
        EbookListManager.instance = instance;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public EbookItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(EbookItemCollectionDao dao) {
        this.dao = dao;
    }

}

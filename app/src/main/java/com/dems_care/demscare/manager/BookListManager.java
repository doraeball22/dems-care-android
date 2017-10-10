package com.dems_care.demscare.manager;

import android.content.Context;

import com.dems_care.demscare.dao.book.BookItemCollectionDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by Bon on 14/9/2560.
 */
public class BookListManager {

    private static BookListManager instance;
    private Context mContext;
    private BookItemCollectionDao dao;

    private BookListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public static BookListManager getInstance() {
        if (instance == null)
            instance = new BookListManager();
        return instance;
    }

    public static void setInstance(BookListManager instance) {
        BookListManager.instance = instance;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public BookItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(BookItemCollectionDao dao) {
        this.dao = dao;
    }

}

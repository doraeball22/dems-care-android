package com.dems_care.demscare.manager;

import android.content.Context;

import com.dems_care.demscare.dao.quiz.QuizItemCollectionDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by Bon on 14/9/2560.
 */
public class QuizListManager {

    private static QuizListManager instance;
    private Context mContext;
    private QuizItemCollectionDao dao;

    private QuizListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public static QuizListManager getInstance() {
        if (instance == null)
            instance = new QuizListManager();
        return instance;
    }

    public static void setInstance(QuizListManager instance) {
        QuizListManager.instance = instance;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public QuizItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(QuizItemCollectionDao dao) {
        this.dao = dao;
    }

}

package com.dems_care.demscare.manager;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by Bon on 14/9/2560.
 */
public class SingletonTemplate {

    private static SingletonTemplate instance;

    public static SingletonTemplate getInstance() {
        if (instance == null)
            instance = new SingletonTemplate();
        return instance;
    }

    private Context mContext;

    private SingletonTemplate() {
        mContext = Contextor.getInstance().getContext();
    }

}

package com.dems_care.demscare;

import android.app.Application;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by Bon on 14/9/2560.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize thing(s) here
        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}

package com.dems_care.demscare.manager;

import android.content.Context;

import com.dems_care.demscare.manager.http.ApiService;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Bon on 9/9/2560.
 */
public class HttpManager {

    private static HttpManager instance;
    private Context mContext;
    private ApiService service;
    private HttpManager() {
        mContext = Contextor.getInstance().getContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://boncoding.xyz/api/")
                // convert json to DAO
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);
    }

    public static HttpManager getInstance() {
        if (instance == null)
            instance = new HttpManager();
        return instance;
    }

    public ApiService getService() {
        return service;
    }

}

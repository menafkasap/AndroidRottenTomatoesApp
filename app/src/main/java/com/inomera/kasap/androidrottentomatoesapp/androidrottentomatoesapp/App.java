package com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp;

import android.app.Application;

import com.inomera.kasap.androidrottentomatoesapp.network.WaspService;
import com.orhanobut.wasp.Wasp;
import com.orhanobut.wasp.utils.LogLevel;
import com.orhanobut.wasp.utils.RequestInterceptor;
import com.orhanobut.wasp.utils.SimpleInterceptor;

import java.util.Map;

/**
 * @author Orhan Obut
 */
@SuppressWarnings("unused")
public class App extends Application {

    private static WaspService service;


    public static WaspService getService() {
        return service;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        RequestInterceptor interceptor = new SimpleInterceptor() {
            @Override
            public void onQueryParamsAdded(Map params) {
                super.onQueryParamsAdded(params);
                params.put("apikey","n594qzwyec5cdgr3tdrpfee3");
            }
        };

        service = new Wasp.Builder(this)
                .setEndpoint("http://api.rottentomatoes.com/api/public/v1.0")
                .setLogLevel(LogLevel.FULL)
                .setRequestInterceptor(interceptor)
                .build()
                .create(WaspService.class);

    }
}
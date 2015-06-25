package com.inomera.kasap.androidrottentomatoesapp.androidrottentomatoesapp;

import android.app.Application;

import com.inomera.kasap.androidrottentomatoesapp.network.MyService;
import com.orhanobut.wasp.Wasp;
import com.orhanobut.wasp.utils.LogLevel;

/**
 * @author Orhan Obut
 */
@SuppressWarnings("unused")
public class App extends Application {

    private static MyService service;

    public static MyService getService() {
        return service;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //todo create and set requestinterceptor


        service = new Wasp.Builder(this)
                .setEndpoint("http://api.rottentomatoes.com")
                .setLogLevel(LogLevel.FULL)
                .build()
                .create(MyService.class);

    }
}
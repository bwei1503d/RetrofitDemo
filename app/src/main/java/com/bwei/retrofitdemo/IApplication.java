package com.bwei.retrofitdemo;

import android.app.Application;

/**
 * Created by muhanxi on 17/6/15.
 */

public class IApplication extends Application {


    public static IApplication application ;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this ;


    }
}

package com.intcore.userstask.di.component;


import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication  extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).Build();
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
}

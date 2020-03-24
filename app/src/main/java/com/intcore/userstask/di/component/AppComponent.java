package com.intcore.userstask.di.component;

import android.app.Application;

import com.intcore.userstask.di.modules.ActivitiesModules;
import com.intcore.userstask.di.modules.AppModule;
import com.intcore.userstask.di.modules.DatabaseModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component (modules = {AndroidSupportInjectionModule.class, ActivitiesModules.class,DatabaseModule.class, AppModule.class})
public interface AppComponent extends AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);
        AppComponent Build();
    }
}

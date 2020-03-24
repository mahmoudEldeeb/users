package com.intcore.userstask.di.modules;

import android.app.Application;

import androidx.room.Room;

import com.intcore.userstask.data.local.UsersDataDao;
import com.intcore.userstask.db.UsersDataase;
import com.intcore.userstask.util.Constatnts;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Singleton
    @Provides
    static UsersDataase provideUsersDataase(Application application){
        return Room.databaseBuilder(application.getApplicationContext(),
                UsersDataase .class, Constatnts.DATABASE_NAME)
                .build();
    }
    @Singleton
    @Provides
    static UsersDataDao provideUsersDataDao(UsersDataase usersDataase){
        return usersDataase.usersDataDao();
    }



}

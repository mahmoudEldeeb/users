package com.intcore.userstask.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.intcore.userstask.data.local.UsersDataDao;


@Database(entities = {User.class},version = 1, exportSchema = false)
public abstract  class UsersDataase extends RoomDatabase {
    public abstract UsersDataDao usersDataDao();

    }



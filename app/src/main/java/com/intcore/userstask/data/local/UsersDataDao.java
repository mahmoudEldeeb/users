package com.intcore.userstask.data.local;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.intcore.userstask.db.User;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UsersDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     void insert(List<User> list);

    @Query("select * from usersTable")
    Single<List<User>> getUsers();

}

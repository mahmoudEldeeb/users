package com.intcore.userstask.data.repositryimplemt;

import com.intcore.userstask.domain.repositry.UsersData;
import com.intcore.userstask.data.local.UsersDataDao;
import com.intcore.userstask.data.remote.ApiModule;
import com.intcore.userstask.db.User;
import com.intcore.userstask.domain.repositry.UsersRepositry;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class UsersRepImpl implements UsersRepositry {
    ApiModule apiModule;
    UsersDataDao usersDataDao;
    public UsersRepImpl(ApiModule api, UsersDataDao dataDao){
        apiModule=api;
        usersDataDao=dataDao;
    }
    @Override
    public Observable<List<User>> getAllUsers() {
        return Observable.create(emitter -> new UsersData(emitter) {
            @Override
            public Single<List<User>> getRemote() {
                return apiModule.getUsers()
                        .flatMap(userModelList ->
                                Observable.fromIterable(userModelList)
                                        .map(item -> new User().convertFromSource(item))
                                        .toList()
                        );

            }
            @Override
            public Single<List<User>> getLocal() {
                return usersDataDao.getUsers();
            }

            @Override
            public void saveCallResult(List<User> data) {
                usersDataDao.insert(data);
            }
        });
    }
}

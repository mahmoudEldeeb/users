package com.intcore.userstask.domain.repositry;

import com.intcore.userstask.db.User;


import java.util.List;

import io.reactivex.ObservableEmitter;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public abstract class UsersData {
    public UsersData(ObservableEmitter<List<User>> emitter){

        Disposable firstDataDisposable = getLocal()
                .subscribe(emitter::onNext);

        getRemote().subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(
                        userModels -> {
                            firstDataDisposable.dispose();
                            saveCallResult(userModels);
                            getLocal().subscribe(emitter::onNext);
                        }
                );

    }
    public abstract Single<List<User>> getRemote();

    public abstract Single<List<User>> getLocal();

    public abstract void saveCallResult(List<User> data);
}

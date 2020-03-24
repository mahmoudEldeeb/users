package com.intcore.userstask.presenters.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.intcore.userstask.db.User;
import com.intcore.userstask.domain.useCases.UsersUsecase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UsersViewModel extends ViewModel {
MutableLiveData<List<User>>usersList=new MutableLiveData<>();
UsersUsecase usersUsecase;

    public MutableLiveData<List<User>> getUsersList() {
        return usersList;
    }

    @Inject
    public UsersViewModel(UsersUsecase usecase){
this.usersUsecase=usecase;
    }
    public void getUsers(){

        usersUsecase.getAllUsers().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> {
                })
                .subscribe(userModels -> {
                    usersList.setValue(userModels);

                });
    }
}

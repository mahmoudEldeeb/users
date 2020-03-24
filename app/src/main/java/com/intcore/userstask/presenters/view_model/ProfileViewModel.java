package com.intcore.userstask.presenters.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.intcore.userstask.db.User;
import com.intcore.userstask.domain.useCases.ProfileUsecase;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ProfileViewModel extends ViewModel {
MutableLiveData<User>Profile=new MutableLiveData<>();
ProfileUsecase profileUsecase;

    public MutableLiveData<User> getProfile() {
        return Profile;
    }

    @Inject
    public ProfileViewModel(ProfileUsecase usecase){
this.profileUsecase=usecase;
    }
    public void getProfileData(int id){

        profileUsecase.getProfileDat(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> {
                })
                .subscribe(user -> {
                    Profile.setValue(user);

                });
    }
}

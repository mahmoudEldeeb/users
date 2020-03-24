package com.intcore.userstask.data.remote;

import com.intcore.userstask.data.models.UserModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiModule {
    @GET("users/")
    Single<List<UserModel>> getUsers();

    @GET("users/{user_id}")
    Single<UserModel> getProfileData(@Path("user_id")int id);

}

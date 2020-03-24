package com.intcore.userstask.domain.repositry;

import com.intcore.userstask.data.models.UserModel;

import io.reactivex.Single;

public interface ProfileRepositry
{
    Single<UserModel> getProfileDat(int id);
}


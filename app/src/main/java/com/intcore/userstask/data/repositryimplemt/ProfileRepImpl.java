package com.intcore.userstask.data.repositryimplemt;

import com.intcore.userstask.data.remote.ApiModule;
import com.intcore.userstask.domain.repositry.ProfileRepositry;
import com.intcore.userstask.data.models.UserModel;
import io.reactivex.Single;
public class ProfileRepImpl implements ProfileRepositry {
    ApiModule apiModule;

    public ProfileRepImpl(ApiModule api){
        apiModule=api;
    }

    @Override
    public Single<UserModel> getProfileDat(int id) {
        return apiModule.getProfileData(id);
    }
}

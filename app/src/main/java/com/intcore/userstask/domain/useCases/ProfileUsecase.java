package com.intcore.userstask.domain.useCases;

import com.intcore.userstask.db.User;
import com.intcore.userstask.domain.repositry.ProfileRepositry;
import javax.inject.Inject;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import com.intcore.userstask.data.models.UserModel;
public class ProfileUsecase {
    ProfileRepositry profileRepositry;
    @Inject
    public ProfileUsecase(ProfileRepositry repositry){
        profileRepositry=repositry;
    }
    public Single<User> getProfileDat(int id){
       return profileRepositry.getProfileDat(id)
               .map(new Function<UserModel, User>() {
                   @Override
                   public User apply(UserModel userModel) throws Exception {
                       return new User().convertFromSource(userModel);
                   }
               })
               ;
    }

}

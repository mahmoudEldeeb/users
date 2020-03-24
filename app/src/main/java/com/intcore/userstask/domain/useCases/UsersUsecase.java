package com.intcore.userstask.domain.useCases;

import com.intcore.userstask.db.User;
import com.intcore.userstask.domain.repositry.UsersRepositry;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class UsersUsecase {
    UsersRepositry usersRepositry;
    @Inject
    public UsersUsecase(UsersRepositry repositry){
        usersRepositry=repositry;
    }
    public Observable<List<User>>getAllUsers(){
       return usersRepositry.getAllUsers();
    }

}

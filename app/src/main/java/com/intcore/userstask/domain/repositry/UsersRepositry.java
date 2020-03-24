package com.intcore.userstask.domain.repositry;

import com.intcore.userstask.db.User;

import java.util.List;

import io.reactivex.Observable;

public interface UsersRepositry
{
    Observable<List<User>>getAllUsers();
}


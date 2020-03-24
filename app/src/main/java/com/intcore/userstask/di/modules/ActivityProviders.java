package com.intcore.userstask.di.modules;

import androidx.lifecycle.ViewModel;

import com.intcore.userstask.di.viewmodel_modules.ViewModelKey;
import com.intcore.userstask.presenters.view_model.UsersViewModel;

import dagger.Binds;
import dagger.Module;

import dagger.multibindings.IntoMap;


@Module
public abstract class ActivityProviders {

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel.class)
    public abstract ViewModel bindUsersViewModel(UsersViewModel viewModel);



}

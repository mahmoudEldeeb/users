package com.intcore.userstask.di.modules;

import com.intcore.userstask.di.scopes.MainPageScope;
import com.intcore.userstask.di.scopes.MainScope;
import com.intcore.userstask.di.scopes.ProfileScope;
import com.intcore.userstask.presenters.views.MainActivity;
import com.intcore.userstask.presenters.views.fragments.MainPageFragment;
import com.intcore.userstask.presenters.views.fragments.ProfileInfoFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentsModulesBuilder {

    @MainPageScope
    @ContributesAndroidInjector(modules = {NetworkModule.class,MainPageProviders.class})
    abstract MainPageFragment contributeMainPageFragment();

    @ProfileScope
    @ContributesAndroidInjector(modules = {NetworkModule.class,ProfileProviders.class})
    abstract ProfileInfoFragment contributeProfileInfoFragment();



}

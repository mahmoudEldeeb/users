package com.intcore.userstask.di.modules;

import com.intcore.userstask.presenters.views.MainActivity;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class ActivitiesModules {

    @ContributesAndroidInjector(modules = {FragmentsModulesBuilder.class})
    abstract MainActivity contributeMainActivity();



}

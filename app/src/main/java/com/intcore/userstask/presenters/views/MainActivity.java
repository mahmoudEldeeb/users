package com.intcore.userstask.presenters.views;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.intcore.userstask.R;
import com.intcore.userstask.di.viewmodel_modules.ViewModelProviderFactory;
import com.intcore.userstask.presenters.view_model.UsersViewModel;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

//    @Inject
//    ViewModelProviderFactory viewModelProviderFactory;
//UsersViewModel usersViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        usersViewModel=ViewModelProviders.of(this,  viewModelProviderFactory)
//                .get(UsersViewModel.class);
//        usersViewModel.getUsers();

    }
}

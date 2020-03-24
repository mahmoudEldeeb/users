package com.intcore.userstask.presenters.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intcore.userstask.R;
import com.intcore.userstask.databinding.FragmentMainPageBinding;
import com.intcore.userstask.di.viewmodel_modules.ViewModelProviderFactory;
import com.intcore.userstask.presenters.view_model.UsersViewModel;
import com.intcore.userstask.presenters.views.adapters.UsersAdapter;
import com.intcore.userstask.util.Constatnts;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class
MainPageFragment extends DaggerFragment {


    public MainPageFragment() {
        // Required empty public constructor
    }

        FragmentMainPageBinding mainPageBinding;
        @Inject
        UsersAdapter usersAdapter;
        @Inject
        ViewModelProviderFactory viewModelProviderFactory;
        UsersViewModel usersViewModel;
        NavController navController;
        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      if(mainPageBinding==null) {
          mainPageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_page, container, false);
          usersViewModel = ViewModelProviders.of(this, viewModelProviderFactory)
                  .get(UsersViewModel.class);
      }
        return mainPageBinding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        navController = Navigation.findNavController(view);
        usersViewModel.getUsers();
        mainPageBinding.resUser.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainPageBinding.resUser.setAdapter(usersAdapter);
        usersViewModel.getUsersList().observe(this,users -> {
            mainPageBinding.loading.setVisibility(View.GONE);
            usersAdapter.addUsers(users);
        });
        usersAdapter.setUserClickListener(user -> {
            Bundle data=new Bundle();
            data.putInt(Constatnts.USR_ID,user.getId());
            navController.navigate(R.id.action_mainPageFragment_to_profileInfoFragment,data);
        });

        }

    }

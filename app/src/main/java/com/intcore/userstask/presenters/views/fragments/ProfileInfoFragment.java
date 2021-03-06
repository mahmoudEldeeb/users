package com.intcore.userstask.presenters.views.fragments;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intcore.userstask.R;
import com.intcore.userstask.databinding.FragmentProfileInfoBinding;
import com.intcore.userstask.di.viewmodel_modules.ViewModelProviderFactory;
import com.intcore.userstask.presenters.view_model.ProfileViewModel;
import com.intcore.userstask.presenters.view_model.UsersViewModel;
import com.intcore.userstask.util.Constatnts;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileInfoFragment extends DaggerFragment {


    public ProfileInfoFragment() {
        // Required empty public constructor
    }

        FragmentProfileInfoBinding profileInfoBinding;
    @Inject
    ViewModelProviderFactory viewModelProviderFactory;
    ProfileViewModel profileViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        profileInfoBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_profile_info, container, false);
        profileViewModel= ViewModelProviders.of(this,  viewModelProviderFactory)
            .get(ProfileViewModel.class);
        int userId=getArguments().getInt(Constatnts.USR_ID);
        profileViewModel.getProfileData(userId);
        profileViewModel.getProfile().observe(this,user -> {
            profileInfoBinding.loading.setVisibility(View.GONE);
            profileInfoBinding.setUser(user);
        });
    return profileInfoBinding.getRoot();
    }

}

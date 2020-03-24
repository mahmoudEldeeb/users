package com.intcore.userstask.di.modules;

import androidx.lifecycle.ViewModel;

import com.intcore.userstask.data.local.UsersDataDao;
import com.intcore.userstask.data.remote.ApiModule;
import com.intcore.userstask.data.repositryimplemt.ProfileRepImpl;
import com.intcore.userstask.data.repositryimplemt.UsersRepImpl;
import com.intcore.userstask.di.scopes.MainPageScope;
import com.intcore.userstask.di.scopes.ProfileScope;
import com.intcore.userstask.di.viewmodel_modules.ViewModelKey;
import com.intcore.userstask.domain.repositry.ProfileRepositry;
import com.intcore.userstask.domain.repositry.UsersRepositry;
import com.intcore.userstask.presenters.view_model.ProfileViewModel;
import com.intcore.userstask.presenters.view_model.UsersViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;


@Module
public abstract class ProfileProviders {

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel.class)
    public abstract ViewModel bindProfileViewModel(ProfileViewModel viewModel);



    @ProfileScope
    @Provides
    public static ProfileRepositry provideProfileRepositry(ApiModule api){
        return new ProfileRepImpl(api);
    }
}

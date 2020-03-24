package com.intcore.userstask.di.modules;

import androidx.lifecycle.ViewModel;

import com.intcore.userstask.data.local.UsersDataDao;
import com.intcore.userstask.data.remote.ApiModule;
import com.intcore.userstask.data.repositryimplemt.UsersRepImpl;
import com.intcore.userstask.di.scopes.MainPageScope;
import com.intcore.userstask.di.scopes.MainScope;
import com.intcore.userstask.di.viewmodel_modules.ViewModelKey;
import com.intcore.userstask.domain.repositry.UsersRepositry;
import com.intcore.userstask.presenters.view_model.UsersViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import retrofit2.Retrofit;


@Module
public abstract class MainPageProviders {

    @Binds
    @IntoMap
    @ViewModelKey(UsersViewModel.class)
    public abstract ViewModel bindUsersViewModel(UsersViewModel viewModel);



    @MainPageScope
    @Provides
    public static UsersRepositry provideUsersRepositry(ApiModule api, UsersDataDao usersDataDao){
        return new UsersRepImpl(api,usersDataDao);
    }


}

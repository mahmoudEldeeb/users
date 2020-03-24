package com.intcore.userstask.presenters.views.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.intcore.userstask.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {

    public SplashFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }
    NavController navController;
    Observable timer;
    Disposable disposable;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        timer=Observable.timer(6000L, TimeUnit.MILLISECONDS)
                .timeInterval()
                .observeOn(Schedulers.newThread());

               disposable= timer.subscribe(longTimed -> {
                    navController.navigate(R.id.action_splashFragment_to_mainPageFragment);
                })
                ;

    }

    @Override
    public void onStop() {
        disposable.dispose();
        super.onStop();
    }
}

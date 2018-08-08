package com.example.vsharko.factoryzadatak.main.mainDI;

import android.content.Context;

import com.example.vsharko.factoryzadatak.Scopes.PerActivity;
import com.example.vsharko.factoryzadatak.main.view.MainActivity;
import com.example.vsharko.factoryzadatak.main.view.MainActivityView;


import dagger.Module;
import dagger.Provides;


@Module
public class MainActivityModule {

    private MainActivity mMainActivity;


    public MainActivityModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @PerActivity
    @Provides
    MainActivityView provideMainActivity(){
        return mMainActivity;
    }

    @PerActivity
    @Provides
    Context provideContext(){
        return mMainActivity;
    }
}

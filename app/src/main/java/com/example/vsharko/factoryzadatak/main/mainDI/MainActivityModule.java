package com.example.vsharko.factoryzadatak.main.mainDI;

import android.content.Context;

import com.example.vsharko.factoryzadatak.AppSope;
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

    @AppSope
    @Provides
    MainActivityView provideMainActivity(){
        return mMainActivity;
    }

    @AppSope
    @Provides
    Context provideContext(){
        return mMainActivity;
    }
}

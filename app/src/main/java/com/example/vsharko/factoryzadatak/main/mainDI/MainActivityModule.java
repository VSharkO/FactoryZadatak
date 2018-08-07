package com.example.vsharko.factoryzadatak.main.mainDI;

import android.content.Context;

import com.example.vsharko.factoryzadatak.AppScope;
import com.example.vsharko.factoryzadatak.main.view.MainActivity;
import com.example.vsharko.factoryzadatak.main.view.MainActivityView;



import dagger.Module;
import dagger.Provides;

@AppScope
@Module
public class MainActivityModule {

    private MainActivity mMainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    @AppScope
    @Provides
    MainActivityView provideMainActivity(){
        return mMainActivity;
    }

    @AppScope
    @Provides
    Context provideContext(){
        return mMainActivity;
    }
}

package com.example.vsharko.factoryzadatak;

import android.app.Application;

import com.example.vsharko.factoryzadatak.database.repository.RepositoryModule;

import timber.log.Timber;

public class App extends Application{
    private static App sInstance;
    private AppComponent mAppComponent;
    @Override
    public void onCreate(){
        super.onCreate();
        sInstance = this;
        Timber.plant(new Timber.DebugTree());
        mAppComponent = DaggerAppComponent.builder()
                .repositoryModule(new RepositoryModule(this))
                .build();
    }

    public static App getInstance() {
        return sInstance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}

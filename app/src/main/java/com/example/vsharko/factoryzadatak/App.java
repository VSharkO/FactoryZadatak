package com.example.vsharko.factoryzadatak;

import android.app.Application;
import android.app.DownloadManager;
import android.support.annotation.NonNull;

import com.bumptech.glide.RequestBuilder;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelper;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelperImpl;
import com.example.vsharko.factoryzadatak.networking.NewsAPIService;
import com.example.vsharko.factoryzadatak.utils.Constants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class App extends Application {
    private NetworkingHelper mNetworkingHelper;
    private static App sInstance;

    @Override
    public void onCreate(){
        super.onCreate();
        sInstance = this;
        AppComponent component = DaggerAppComponent.builder().build();
        this.mNetworkingHelper = component.getNetworkHelper();
        Timber.plant(new Timber.DebugTree());
    }
    public static App getInstance() {
        return sInstance;
    }

    public NetworkingHelper getNetworkHelper(){
        return mNetworkingHelper;
    }

}

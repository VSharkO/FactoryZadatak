package com.example.vsharko.factoryzadatak;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.vsharko.factoryzadatak.helpers.networking.NetworkingHelper;
import com.example.vsharko.factoryzadatak.helpers.networking.NetworkingHelperImpl;
import com.example.vsharko.factoryzadatak.helpers.networking.NewsAPIService;
import com.example.vsharko.factoryzadatak.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    Retrofit retrofit;
    NetworkingHelper networkingHelper;
    private static App sInstance;
    Gson gson;

    @Override
    public void onCreate(){
        super.onCreate();
        sInstance = this;
        retrofit = provideRestClient();
        NewsAPIService service = createNewsAPIService(retrofit);
        networkingHelper = new NetworkingHelperImpl(service);

    }

    private NewsAPIService createNewsAPIService(Retrofit retrofit) {
        return retrofit.create(NewsAPIService.class);
    }


    @NonNull
    private Retrofit provideRestClient() {

        gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(Constants.NEWS_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static App getInstance() {
        return sInstance;
    }

    public NetworkingHelper getNetworkingHelper(){
        return networkingHelper;
    }


}

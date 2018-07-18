package com.example.vsharko.factoryzadatak;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.vsharko.factoryzadatak.helpers.networking.NetworkingHelper;
import com.example.vsharko.factoryzadatak.helpers.networking.NetworkingHelperImpl;
import com.example.vsharko.factoryzadatak.helpers.networking.NewsAPIService;
import com.example.vsharko.factoryzadatak.database.repository.FakeDatabase;
import com.example.vsharko.factoryzadatak.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    Retrofit retrofit;
    NetworkingHelper networkingHelper;
    private static App sInstance;
    FakeDatabase model;

    @Override
    public void onCreate(){
        super.onCreate();
        sInstance = this;
        retrofit = provideRestClient();
        NewsAPIService service = createNewsAPIService(retrofit);
        this.networkingHelper = new NetworkingHelperImpl(service);
        model = FakeDatabase.getInstance();

    }

    private NewsAPIService createNewsAPIService(Retrofit retrofit) {
        return retrofit.create(NewsAPIService.class);
    }

    @NonNull
    private Retrofit provideRestClient() {

        return new Retrofit.Builder()
                .baseUrl(Constants.NEWS_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static App getInstance() {
        return sInstance;
    }

    public NetworkingHelper getNetworkingHelper(){
        return this.networkingHelper;
    }

}

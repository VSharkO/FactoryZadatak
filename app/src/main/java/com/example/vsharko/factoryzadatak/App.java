package com.example.vsharko.factoryzadatak;

import android.app.Application;
import android.support.annotation.NonNull;

import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelper;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelperImpl;
import com.example.vsharko.factoryzadatak.networking.NewsAPIService;
import com.example.vsharko.factoryzadatak.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private Retrofit retrofit;
    private NetworkingHelper networkingHelper;
    private static App sInstance;

    @Override
    public void onCreate(){
        super.onCreate();
        sInstance = this;
        retrofit = provideRestClient();
        NewsAPIService service = createNewsAPIService(retrofit);
        this.networkingHelper = new NetworkingHelperImpl(service);

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

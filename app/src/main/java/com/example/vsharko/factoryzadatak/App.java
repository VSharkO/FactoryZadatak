package com.example.vsharko.factoryzadatak;

import android.app.Application;
import android.support.annotation.NonNull;

import com.bumptech.glide.RequestBuilder;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelper;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelperImpl;
import com.example.vsharko.factoryzadatak.networking.NewsAPIService;
import com.example.vsharko.factoryzadatak.utils.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

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
        Timber.plant(new Timber.DebugTree());
    }

    private NewsAPIService createNewsAPIService(Retrofit retrofit) {
        return retrofit.create(NewsAPIService.class);
    }

    @NonNull
    private Retrofit provideRestClient() {

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.d(message);
            }
        });

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

         if(BuildConfig.DEBUG) {
             okHttpClientBuilder.addInterceptor(logging);
         }


        return new Retrofit.Builder()
                .baseUrl(Constants.NEWS_API_BASE_URL)
                .client(okHttpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static App getInstance() {
        return sInstance;
    }

    public NetworkingHelper getNetworkingHelper(){
        return sInstance.networkingHelper;
    }

}

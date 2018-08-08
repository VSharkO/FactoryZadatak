package com.example.vsharko.factoryzadatak.networking.networkDI;
import com.example.vsharko.factoryzadatak.networking.NewsAPIService;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelper;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelperImpl;
import com.example.vsharko.factoryzadatak.utils.Constants;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkhttpModule.class)
public class NetworkModule {

    @Singleton
    @Provides
    public NetworkingHelper provideNetworkingHelper(NewsAPIService service){
        return new NetworkingHelperImpl(service);
    }
    @Singleton
    @Provides
    public Retrofit provideRestClient(OkHttpClient okHttpClient) {
            return new Retrofit.Builder()
                    .baseUrl(Constants.NEWS_API_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }
    @Singleton
    @Provides
    public NewsAPIService provideNewsAPIService(Retrofit retrofit) {
        return retrofit.create(NewsAPIService.class);
    }

}

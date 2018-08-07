package com.example.vsharko.factoryzadatak.networking.networkDI;
import com.example.vsharko.factoryzadatak.AppScope;
import com.example.vsharko.factoryzadatak.networking.NewsAPIService;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelper;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelperImpl;
import com.example.vsharko.factoryzadatak.utils.Constants;


import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = OkhttpModule.class)
public class NetworkModule {

    @AppScope
    @Provides
    public NetworkingHelper provideNetworkingHelper(NewsAPIService service){
        return new NetworkingHelperImpl(service);
    }
    @AppScope
    @Provides
    public Retrofit provideRestClient(OkHttpClient okHttpClient) {
            return new Retrofit.Builder()
                    .baseUrl(Constants.NEWS_API_BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
    }
    @AppScope
    @Provides
    public NewsAPIService provideNewsAPIService(Retrofit retrofit) {
        return retrofit.create(NewsAPIService.class);
    }

}

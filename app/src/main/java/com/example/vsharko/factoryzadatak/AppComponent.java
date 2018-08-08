package com.example.vsharko.factoryzadatak;

import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.database.repository.RepositoryModule;
import com.example.vsharko.factoryzadatak.database.room.ArticlesDao;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelper;
import com.example.vsharko.factoryzadatak.networking.networkDI.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, RepositoryModule.class})
public interface AppComponent {
    ArticlesDao injectDao();
    ArticlesRepository injectRepository();
    NetworkingHelper injectNetworkingHelper();
}

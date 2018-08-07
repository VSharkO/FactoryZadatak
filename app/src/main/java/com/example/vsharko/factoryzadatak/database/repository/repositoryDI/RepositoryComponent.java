package com.example.vsharko.factoryzadatak.database.repository.repositoryDI;
import com.example.vsharko.factoryzadatak.AppScope;
import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.database.room.ArticlesDao;

import dagger.Component;

@AppScope
@Component(modules = RepositoryModule.class)
public interface RepositoryComponent {
    ArticlesDao injectDao();
    ArticlesRepository injectRepository();
}

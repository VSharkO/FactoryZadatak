package com.example.vsharko.factoryzadatak.database.repository.repositoryDI;

import android.content.Context;

import com.example.vsharko.factoryzadatak.AppScope;
import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepositoryRoom;
import com.example.vsharko.factoryzadatak.database.room.ArticlesDao;
import com.example.vsharko.factoryzadatak.database.room.ArticlesRoomDatabase;
import dagger.Module;
import dagger.Provides;

@AppScope
@Module
public class RepositoryModule {
    private Context mContext;

    public RepositoryModule(Context context) {
        mContext = context;
    }

    @AppScope
    @Provides
    ArticlesDao provideDao() {
        ArticlesRoomDatabase database = ArticlesRoomDatabase.getDatabase(mContext);
        return database.articlesDao();
    }

    @AppScope
    @Provides
    ArticlesRepository provideRepository(){
        return new ArticlesRepositoryRoom();
    }

}

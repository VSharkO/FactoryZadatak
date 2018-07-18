package com.example.vsharko.factoryzadatak.database.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.vsharko.factoryzadatak.model.Article;

@Database(entities = {Article.class}, version = 1)
public abstract class ArticlesRoomDatabase extends RoomDatabase {
    public abstract ArticlesDao articlesDao();

    private static ArticlesRoomDatabase INSTANCE;

    public static ArticlesRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ArticlesRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ArticlesRoomDatabase.class, "articles_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

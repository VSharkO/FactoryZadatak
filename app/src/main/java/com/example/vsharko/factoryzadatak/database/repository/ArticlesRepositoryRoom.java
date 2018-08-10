package com.example.vsharko.factoryzadatak.database.repository;
import com.example.vsharko.factoryzadatak.App;
import com.example.vsharko.factoryzadatak.AppComponent;
import com.example.vsharko.factoryzadatak.database.room.ArticlesDao;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.utils.DbResponseListener;
import java.util.List;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class ArticlesRepositoryRoom implements ArticlesRepository {

    private ArticlesDao articlesDao;

    public ArticlesRepositoryRoom() {
        AppComponent component = App.getInstance().getAppComponent();
        articlesDao = component.injectDao();
    }

    @Override
    public void getArticles(final DbResponseListener listener) {

        articlesDao.getArticles().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<List<Article>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Article> articles) {
                        listener.onSuccess(articles);
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    @Override
    public void setListOfArticles(final List<Article> listOfArticles) {
        Completable.fromAction(new Action() {
            @Override
            public void run(){
                articlesDao.deleteAllArticles();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Completable.fromAction(new Action() {
                            @Override
                            public void run(){
                                for (Article article: listOfArticles) {
                                    articlesDao.insert(article);
                                }
                            }

                        }).subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });

    }
}

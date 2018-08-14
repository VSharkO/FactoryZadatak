package com.example.vsharko.factoryzadatak.database.repository;
import com.example.vsharko.factoryzadatak.App;
import com.example.vsharko.factoryzadatak.AppComponent;
import com.example.vsharko.factoryzadatak.database.room.ArticlesDao;
import com.example.vsharko.factoryzadatak.model.Article;
import com.example.vsharko.factoryzadatak.utils.DbResponseListener;
import java.util.List;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

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
                .subscribe(new SingleObserver<List<Article>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<Article> articles) {
                        listener.onSuccess(articles);
                        Timber.i("done update from db");
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailure(e);
                    }
                });

    }

    @Override
    public void setListOfArticles(final List<Article> listOfArticles) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                articlesDao.deleteAllArticles();
                for (Article article: listOfArticles) {
                                    articlesDao.insert(article);
                                }
            }
        };

        Completable.fromRunnable(runnable).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        Timber.i("done!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e);
                    }
                });
    }
}

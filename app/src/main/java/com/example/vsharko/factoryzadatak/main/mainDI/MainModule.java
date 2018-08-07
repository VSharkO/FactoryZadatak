package com.example.vsharko.factoryzadatak.main.mainDI;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import com.example.vsharko.factoryzadatak.AppScope;
import com.example.vsharko.factoryzadatak.database.repository.ArticlesRepository;
import com.example.vsharko.factoryzadatak.database.repository.repositoryDI.RepositoryModule;
import com.example.vsharko.factoryzadatak.networking.networkDI.NetworkModule;
import com.example.vsharko.factoryzadatak.R;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenter;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenterImpl;
import com.example.vsharko.factoryzadatak.main.view.MainActivityView;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelper;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NetworkModule.class,MainActivityModule.class, RepositoryModule.class})
public class MainModule {

    @AppScope
    @Provides
    MainPresenter providePresenter(MainActivityView view, NetworkingHelper helper,
                                   ArticlesRepository repository){
        return new MainPresenterImpl(view,helper,repository);
    }

    @AppScope
    @Provides
    public AlertDialog provideAlertDialog(Context context){
        AlertDialog.Builder mAlertDialogBuilder = new AlertDialog.Builder(context);
        mAlertDialogBuilder.setMessage(context.getString(R.string.no_connection_massage));
        mAlertDialogBuilder.setPositiveButton(android.R.string.ok,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        return mAlertDialogBuilder.create();
    }



}

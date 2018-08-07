package com.example.vsharko.factoryzadatak.main.mainDI;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import com.example.vsharko.factoryzadatak.AppSope;
import com.example.vsharko.factoryzadatak.networking.networkDI.NetworkModule;
import com.example.vsharko.factoryzadatak.R;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenter;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenterImpl;
import com.example.vsharko.factoryzadatak.main.view.MainActivityView;
import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelper;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NetworkModule.class,MainActivityModule.class})
public class MainModule {

    @AppSope
    @Provides
    MainPresenter providePresenter(MainActivityView view, NetworkingHelper helper){
        return new MainPresenterImpl(view,helper);
    }

    @AppSope
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

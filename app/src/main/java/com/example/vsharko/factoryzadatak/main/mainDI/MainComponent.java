package com.example.vsharko.factoryzadatak.main.mainDI;
import android.support.v7.app.AlertDialog;

import com.example.vsharko.factoryzadatak.AppScope;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenter;
import com.example.vsharko.factoryzadatak.main.view.MainActivity;

import dagger.Component;

@AppScope
@Component(modules = {MainModule.class,MainActivityModule.class})
public interface MainComponent {
    MainPresenter injectPresenter();
    AlertDialog injectAlertDialog();
}

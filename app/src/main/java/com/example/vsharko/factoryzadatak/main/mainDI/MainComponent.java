package com.example.vsharko.factoryzadatak.main.mainDI;
import android.support.v7.app.AlertDialog;

import com.example.vsharko.factoryzadatak.AppSope;
import com.example.vsharko.factoryzadatak.main.presenter.MainPresenter;

import dagger.Component;

@AppSope
@Component(modules = {MainModule.class})
public interface MainComponent {
    MainPresenter injectPresenter();
    AlertDialog injectAlertDialog();
}

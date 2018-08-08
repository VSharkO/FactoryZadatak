package com.example.vsharko.factoryzadatak.main.mainDI;
import com.example.vsharko.factoryzadatak.AppComponent;
import com.example.vsharko.factoryzadatak.scopes.PerActivity;
import com.example.vsharko.factoryzadatak.main.view.MainActivity;
import dagger.Component;

@PerActivity
@Component(modules = {MainModule.class,MainActivityModule.class}, dependencies = AppComponent.class)

public interface MainComponent {
    void inject(MainActivity mainActivity);
}

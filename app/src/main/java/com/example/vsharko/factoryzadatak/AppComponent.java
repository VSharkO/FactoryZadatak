package com.example.vsharko.factoryzadatak;

import com.example.vsharko.factoryzadatak.networking.helpers.NetworkingHelper;

import dagger.Component;

@AppSope
@Component(modules = {NetworkModule.class})
public interface AppComponent{
    NetworkingHelper getNetworkHelper();
}

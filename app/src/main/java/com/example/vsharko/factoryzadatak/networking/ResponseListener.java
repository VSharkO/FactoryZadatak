package com.example.vsharko.factoryzadatak.networking;

public interface ResponseListener<T> {
    void onSuccess(T callback);
    void onFailure(Throwable throwable);
}

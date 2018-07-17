package com.example.vsharko.factoryzadatak.helpers;

public interface ResponseListener<T> {
    void onSuccess(T callback);
    void onFailure(Throwable throwable);
}

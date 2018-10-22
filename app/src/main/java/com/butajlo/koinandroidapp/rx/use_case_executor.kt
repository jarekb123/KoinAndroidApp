package com.butajlo.koinandroidapp.rx

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.execute(onSuccess: (T) -> Unit, onError: (Throwable) -> Unit) {
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnSuccess(onSuccess)
        .doOnError(onError)
        .subscribe()
}
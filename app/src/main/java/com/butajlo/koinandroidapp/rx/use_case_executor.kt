package com.butajlo.koinandroidapp.rx

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.rxkotlin.subscribeBy

fun <T> Single<T>.execute(onSuccess: (T) -> Unit, onError: (Throwable) -> Unit) : Disposable where T : Any {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeBy(
            onSuccess = onSuccess,
            onError = onError
        )
}
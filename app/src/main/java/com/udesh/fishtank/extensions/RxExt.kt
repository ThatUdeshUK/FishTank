package com.udesh.fishtank.extensions

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.mainThreadSafely() = this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
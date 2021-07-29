package com.example.domain.usecases.base

import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.functions.Consumer

abstract class SingleObserver<T> : DefaultObserver() {

    fun successConsumer(): Consumer<T> {
        return Consumer { onSuccess(it) }
    }

    abstract fun onSuccess(@NonNull data: T)
}

package com.example.domain.usecases.base

import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.functions.Consumer


abstract class DefaultObserver {

    fun subscribeConsumer(): Consumer<Any> {
        return Consumer { onSubscribe() }
    }

    fun errorConsumer(): Consumer<in Throwable> {
        return Consumer { onError(it) }
    }

    fun finally(): Action {
        return Action { doFinally() }
    }

    open fun onSubscribe() {}
    open fun doFinally() {}
    abstract fun onError(throwable: Throwable)
}

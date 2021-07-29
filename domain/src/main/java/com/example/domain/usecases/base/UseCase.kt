package com.example.domain.usecases.base

import com.example.domain.scheduler.PostScheduler
import com.example.domain.scheduler.SubScheduler
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class UseCase<in Params, out T>(
    private val subScheduler: SubScheduler,
    private val postScheduler: PostScheduler
) {

    private val compositeDisposable = CompositeDisposable()

    internal fun add(disposable: Disposable) {
        if (!disposable.isDisposed) {
            compositeDisposable.add(disposable)
        }
    }

    internal fun dispose() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }

    internal fun subScheduler(): Scheduler {
        return subScheduler.subScheduler()
    }

    internal fun postScheduler(): Scheduler {
        return postScheduler.postScheduler()
    }

    protected abstract fun build(params: Params): T
}

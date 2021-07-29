package com.example.domain.usecases.base

import com.example.domain.scheduler.PostScheduler
import com.example.domain.scheduler.SubScheduler
import io.reactivex.rxjava3.core.Single

abstract class SingleUseCase<in Params, T>(
    subScheduler: SubScheduler,
    postScheduler: PostScheduler
) : UseCase<Params, Single<T>>(subScheduler, postScheduler) {

    fun execute(params: Params, observer: SingleObserver<T>) {
        val observable = build(params)
            .subscribeOn(subScheduler())
            .observeOn(postScheduler())
            .doOnSubscribe(observer.subscribeConsumer())
            .doFinally(observer.finally())
        add(
            observable.subscribe(
                observer.successConsumer(),
                observer.errorConsumer()
            )
        )
    }
}

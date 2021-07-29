package com.example.exercise.di

import com.example.domain.scheduler.PostScheduler
import com.example.domain.scheduler.SubScheduler
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import org.koin.dsl.module

val appModule = module {

    single<SubScheduler> { SubSchedulerImpl() }

    single<PostScheduler> { PostSchedulerImpl() }
}

class SubSchedulerImpl : SubScheduler {

    override fun subScheduler(): Scheduler = Schedulers.io()
}

class PostSchedulerImpl : PostScheduler {

    override fun postScheduler(): Scheduler = AndroidSchedulers.mainThread()
}

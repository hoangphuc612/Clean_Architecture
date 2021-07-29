package com.example.domain.scheduler

import io.reactivex.rxjava3.core.Scheduler

interface SubScheduler {
    fun subScheduler(): Scheduler
}

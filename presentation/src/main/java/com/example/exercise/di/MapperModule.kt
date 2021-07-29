package com.example.exercise.di

import com.example.exercise.mapper.RepoModelMapper
import com.example.exercise.mapper.UserModelMapper
import org.koin.dsl.module

val mapperModule = module {

    single { UserModelMapper() }

    single { RepoModelMapper() }
}

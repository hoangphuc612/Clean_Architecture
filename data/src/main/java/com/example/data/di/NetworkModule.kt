package com.example.data.di

import com.example.data.repository.source.remote.api.ApiService
import com.example.data.repository.source.remote.api.ServiceGenerator
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {

    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

    single { provideApiService(get()) }

    single<Gson> {
        GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }
    single {
        ServiceGenerator.buildRestApi(get())
    }
}

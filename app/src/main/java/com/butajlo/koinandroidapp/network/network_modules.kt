package com.butajlo.koinandroidapp.network

import com.butajlo.koinandroidapp.data.repository.PlaceholderRepositoryImpl
import com.butajlo.koinandroidapp.data.service.PlaceholderService
import com.butajlo.koinandroidapp.domain.repository.PlaceholderRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import org.koin.experimental.builder.scope
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { createOkHttpClient() }
    single<PlaceholderService> { createRetrofit(get()).create(PlaceholderService::class.java) }
    single<PlaceholderRepository> { PlaceholderRepositoryImpl(get(), get()) }
}

val sessionModule = module {
    scope("user_session") { SessionManager() }
}

const val apiUrl = "https://jsonplaceholder.typicode.com"

private fun createRetrofit(okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(apiUrl)
            .client(okHttpClient)
            .build()

private fun createOkHttpClient() =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
